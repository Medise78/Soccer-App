package com.medise.soccerscoreapp.ui.search

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.medise.soccerscoreapp.R
import com.medise.soccerscoreapp.databinding.FragmentSearchBinding
import com.medise.soccerscoreapp.ui.adapters.TeamsNameAdapter
import com.medise.soccerscoreapp.ui.base_fragment.BaseFragment
import com.medise.soccerscoreapp.util.Resource
import com.medise.soccerscoreapp.util.hide
import com.medise.soccerscoreapp.util.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {
    override val viewModel: SearchViewModel by viewModels()

    private val teamsNameAdapter by lazy { TeamsNameAdapter(requireContext()) }
    private var navController:NavController? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setOnClickListener()
        setupRecyclerView()
        searchInit(binding.edSearchTeamName.editableText.toString())
    }

    override fun onStart() {
        super.onStart()
        observeData()
        if (navController?.currentDestination?.id == R.id.searchFragment){

        }else{
            observeData().cancel()
        }
    }

    private fun observeData() = lifecycleScope.launch {
        viewModel.searchTeam.collectLatest { resource ->
            when (resource) {
                is Resource.Loading -> {
                    if (binding.edSearchTeamName.editableText.toString().isEmpty()) {
                        binding.loadingTeamName.hide()
                    } else {
                        binding.loadingTeamName.show()
                    }
                }

                is Resource.Success -> {
                    resource.data?.let {
                        binding.loadingTeamName.hide()
                        binding.rvTeamsName.show()
                        teamsNameAdapter.teams = it.data?.toList() ?: emptyList()
                    }
                }

                is Resource.Error -> {

                }
            }
        }
    }

    private fun searchInit(query: String) = with(binding) {
        edSearchTeamName.setText(query)
        edSearchTeamName.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_GO) {
                updateCharacterList()
                true
            } else {
                false
            }
        }

        edSearchTeamName.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                updateCharacterList()
                true
            } else {
                false
            }
        }

        edSearchTeamName.doOnTextChanged { text, start, before, count ->
            binding.rvTeamsName.hide()
            updateCharacterList()
        }
    }

    private fun updateCharacterList() = with(binding) {
        edSearchTeamName.editableText.toString().let {
            if (it.isNotEmpty()) {
                searchQuery(it)
            }
        }
    }

    private fun searchQuery(search: String) {
        viewModel.searchTeam(search)
    }

    private fun setOnClickListener() {
        teamsNameAdapter.onClickListener {
            val action = SearchFragmentDirections
                .actionSearchFragmentToTeamDetailFragment(it)
            findNavController().navigate(action)
        }
    }

    private fun setupRecyclerView() = with(binding) {
        rvTeamsName.apply {
            adapter = teamsNameAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun getViewBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSearchBinding =
        FragmentSearchBinding.inflate(layoutInflater, container, false)
}