package com.medise.soccerscoreapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.kwasow.bottomnavigationcircles.BottomNavigationCircles
import com.google.android.material.snackbar.Snackbar
import com.medise.soccerscoreapp.R
import com.medise.soccerscoreapp.databinding.FragmentHomeBinding
import com.medise.soccerscoreapp.ui.adapters.HomeLeaguesAdapter
import com.medise.soccerscoreapp.ui.adapters.MatchScoreAdapter
import com.medise.soccerscoreapp.ui.base_fragment.BaseFragment
import com.medise.soccerscoreapp.util.Resource
import com.medise.soccerscoreapp.util.hide
import com.medise.soccerscoreapp.util.show
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import okhttp3.Cache
import java.io.File
import kotlin.coroutines.cancellation.CancellationException

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()

    private val navController:NavController? = null
    private val matchScoreAdapter by lazy { MatchScoreAdapter(requireContext()) }
    private val leaguesAdapter by lazy { HomeLeaguesAdapter(requireContext()) }



    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setOnMatchClick()
        fetchLeaguesData()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onStart() {
        super.onStart()
        setupRecyclerView()
        fetchData()
        if (navController?.currentDestination?.id == R.id.homeFragment){
            reloadData()
        }else {
            fetchData().cancel()
            binding.swipeRefresh.isRefreshing = false
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("NotifyDataSetChanged")
    private fun reloadData() {
        binding.swipeRefresh.setOnRefreshListener {
            binding.swipeRefresh.isRefreshing = false
            viewModel.reload()
            matchScoreAdapter.notifyDataSetChanged()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun fetchData() = lifecycleScope.launch {
        viewModel.getMatchScore.catch {
            Cache(requireContext().cacheDir , 50 * 1024 * 1024).directory.apply {
                File("http_cache")
            }
        }
            .collect { resource ->
            when (resource) {
                is Resource.Error -> {
                    binding.reloading.hide()
                    binding.btnRefresh.show()
                    Snackbar.make(binding.root,resource.message?:"Error" , Snackbar.LENGTH_LONG).show()
                }
                is Resource.Success -> {
                    val nav = activity?.findViewById<BottomNavigationCircles>(R.id.bottomNavigation)
                    nav?.show()
                    binding.swipeRefresh.isEnabled = true
                    binding.btnRefresh.hide()
                    binding.reloading.hide()
                    resource.data?.let {
                        matchScoreAdapter.matches =
                            it.data?.toMutableList() ?: emptyList()
                    }
                }
                is Resource.Loading -> {
                    val nav = activity?.findViewById<BottomNavigationCircles>(R.id.bottomNavigation)
                    nav?.hide()
                    binding.reloading.show()
                    binding.btnRefresh.hide()
                    binding.swipeRefresh.isEnabled = false
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun fetchLeaguesData() = lifecycleScope.launch {
        viewModel.getLeagues.collect { resource ->
            when (resource) {
                is Resource.Success -> {
                    viewModel.getLeagues.collect { result ->
                        leaguesAdapter.leagues = result.data?.data?.map { it }!!
                    }
                }
                else -> Unit
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun setOnMatchClick() {
        leaguesAdapter.setOnClickListener {
            val action = HomeFragmentDirections
                .actionHomeFragmentToLeaderBoardFragment(it)
            findNavController().navigate(action)
            fetchData().cancel()
        }
        matchScoreAdapter.setonClickListener {
            val action = HomeFragmentDirections
                .actionHomeFragmentToMatchDetailFragment(it)
            findNavController().navigate(action)
            fetchData().cancel()
        }

        binding.btnRefresh.setOnClickListener {
            it.hide()
            binding.reloading.show()
            viewModel.reload()
        }
    }

    private fun setupRecyclerView() = with(binding) {
        rvHomeFragment.apply {
            adapter = matchScoreAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        rvHomeLeagues.apply {
            adapter = leaguesAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }



    override fun getViewBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater, container, false)
}