package com.medise.soccerscoreapp.ui.leagues

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.kwasow.bottomnavigationcircles.BottomNavigationCircles
import com.medise.soccerscoreapp.R
import com.medise.soccerscoreapp.databinding.FragmentLeaguesBinding
import com.medise.soccerscoreapp.ui.adapters.LeaguesAdapter
import com.medise.soccerscoreapp.ui.base_fragment.BaseFragment
import com.medise.soccerscoreapp.util.Resource
import com.medise.soccerscoreapp.util.hide
import com.medise.soccerscoreapp.util.show
import com.medise.soccerscoreapp.util.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LeaguesFragment : BaseFragment<FragmentLeaguesBinding, LeaguesViewModel>() {

    override val viewModel: LeaguesViewModel by viewModels()

    private val leaguesAdapter by lazy { LeaguesAdapter(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setOnClick()
        setUpRecyclerView()
        getLeaguesData()
    }

    private fun getLeaguesData() = lifecycleScope.launch {
        viewModel.getLeagues.collect{ resource ->
            when(resource){
                is Resource.Error -> {
                    resource.message?.let {
                        toast(it)
                    }
                }
                is Resource.Success -> {
                    val nav = activity?.findViewById<BottomNavigationCircles>(R.id.bottomNavigation)
                    nav?.show()
                    val nav1 = activity?.findViewById<FrameLayout>(R.id.frameLayout)
                    nav1?.show()
                    binding.loadLeaguesWaiting.hide()
                    resource.data?.let {
                        leaguesAdapter.leagues = it.data.toList()
                    }
                }

                is Resource.Loading ->{
                    binding.loadLeaguesWaiting.show()
                    val nav = activity?.findViewById<FrameLayout>(R.id.frameLayout)
                    nav?.hide()
                }
            }
        }
    }

    private fun setOnClick(){
        leaguesAdapter.setOnClickListener {
            val action = LeaguesFragmentDirections
                .actionLeagueFragmentToLeaderBoardFragment(it)
            findNavController().navigate(action)
        }
    }

    private fun setUpRecyclerView() = with(binding){
        rvLeagues.apply {
            adapter = leaguesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun getViewBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLeaguesBinding =
        FragmentLeaguesBinding.inflate(layoutInflater, container, false)

}