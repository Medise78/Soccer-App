package com.medise.soccerscoreapp.ui.leader_board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.github.kwasow.bottomnavigationcircles.BottomNavigationCircles
import com.google.android.material.snackbar.Snackbar
import com.medise.soccerscoreapp.R
import com.medise.soccerscoreapp.databinding.FragmentLeaderBoardBinding
import com.medise.soccerscoreapp.ui.adapters.LeagueStandingAdapter
import com.medise.soccerscoreapp.ui.base_fragment.BaseFragment
import com.medise.soccerscoreapp.ui.leagues.LeaguesFragmentDirections
import com.medise.soccerscoreapp.util.Resource
import com.medise.soccerscoreapp.util.hide
import com.medise.soccerscoreapp.util.show
import com.medise.soccerscoreapp.util.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LeaderBoardFragment : BaseFragment<FragmentLeaderBoardBinding, LeaderBoardViewModel>() {
    override val viewModel: LeaderBoardViewModel by viewModels()

    private var navController:NavController? = null
    private val leaderBoardAdapter by lazy { LeagueStandingAdapter(requireContext()) }
    private val args: LeaderBoardFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.findViewById<BottomNavigationCircles>(R.id.bottomNavigation)?.visibility = View.GONE
        viewModel.loadSeason(args.league.currentSeasonId)
        setupLeagueCard()
        setUpRecyclerView()

    }

    override fun onStart() {
        super.onStart()

        if (navController?.currentDestination?.id == R.id.leaderBoardFragment){
            observeData()
        }else{
            observeData().cancel()
        }
    }

    private fun observeData() = lifecycleScope.launch {
        viewModel.getLeaderBoard.collect { result ->
            when (result) {
                is Resource.Error -> {
                    val nav = activity?.findViewById<BottomNavigationCircles>(R.id.bottomNavigation)
                    nav?.hide()
                    binding.lottieWaiting.hide()
                    toast(result.message ?: "error")
                    Snackbar.make(binding.root , result.message?:"" , Snackbar.LENGTH_LONG).show()
                }
                is Resource.Success -> {
                    val nav = activity?.findViewById<BottomNavigationCircles>(R.id.bottomNavigation)
                    nav?.hide()
                    binding.lottieWaiting.hide()
                    binding.containerHeader.show()
                    binding.line.show()
                    binding.rvStanding.show()
                    result.data?.data?.forEach {
                        leaderBoardAdapter.standingLeague = it.leagueStandingsDto?.data?.toList()?: emptyList()
                    }
                }
                is Resource.Loading ->{
                    binding.lottieWaiting.show()
                    binding.containerHeader.hide()
                    binding.line.hide()
                    binding.rvStanding.hide()
                    val nav = activity?.findViewById<BottomNavigationCircles>(R.id.bottomNavigation)
                    nav?.hide()
                }
            }
        }
    }

    private fun setUpRecyclerView() = with(binding) {
        rvStanding.apply {
            adapter = leaderBoardAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setupLeagueCard() = with(binding){
        tvDescLeagueLeaderBoard.text = args.league.name
        tvCountryLeaderBoard.text = args.league.country.data.name
        tvEventLeaderBoard.text = args.league.season.data.name

        Glide.with(requireContext())
            .load(args.league.country.data.imagePath)
            .into(imgCountryLeaderBoard)
        Glide.with(requireContext())
            .load(args.league.logoPath)
            .into(imgLeagueLeaderBoard)

        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun getViewBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLeaderBoardBinding =
        FragmentLeaderBoardBinding.inflate(layoutInflater, container, false)

}