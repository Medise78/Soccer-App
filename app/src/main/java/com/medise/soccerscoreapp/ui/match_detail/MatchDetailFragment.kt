package com.medise.soccerscoreapp.ui.match_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.github.kwasow.bottomnavigationcircles.BottomNavigationCircles
import com.medise.soccerscoreapp.R
import com.medise.soccerscoreapp.databinding.FragmentMatchDetailBinding
import com.medise.soccerscoreapp.ui.base_fragment.BaseFragment
import com.medise.soccerscoreapp.util.hide
import com.medise.soccerscoreapp.util.lastMatch
import com.medise.soccerscoreapp.util.toast
import kotlinx.android.synthetic.main.layout_toolbar.*


class MatchDetailFragment : BaseFragment<FragmentMatchDetailBinding, MatchDetailViewModel>() {
    override val viewModel: MatchDetailViewModel by viewModels()

    private val args: MatchDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.findViewById<BottomNavigationCircles>(R.id.bottomNavigation)?.hide()
        setupView()
    }

    private fun setupView() = with(binding) {
        Glide.with(requireContext())
            .load(args.matchDetail.league?.data?.logoPath)
            .into(imgLeague)

        Glide.with(requireContext())
            .load(args.matchDetail.localTeam?.data?.logoPath)
            .into(imgTeamHomeMatchDetail)

        Glide.with(requireContext())
            .load(args.matchDetail.visitorTeam?.data?.logoPath)
            .into(imgTeamAwayMatchDetail)

        tvFormationAwayMatchDetail.text = args.matchDetail.formationsDto?.visitorteamFormation
        tvFormationHomeMatchDetail.text = args.matchDetail.formationsDto?.localteamFormation
        tvScoreHomeMatchDetail.text = args.matchDetail.scoresDto?.localteamScore.toString()
        tvScoreAwayMatchDetail.text = args.matchDetail.scoresDto?.visitorteamScore.toString()
        tvTeamHomeNameMatchDetail.text = args.matchDetail.localTeam?.data?.name
        tvTeamAwayNameMatchDetail.text = args.matchDetail.visitorTeam?.data?.name
        tvMatchNameMatchDetail.text =
            "${args.matchDetail.localTeam?.data?.name} VS ${args.matchDetail.visitorTeam?.data?.name}"
        tvMatchDateMatchDetail.text = args.matchDetail.timeDto?.startingAtDto?.date
        tvScoreAwayDetailMatchDetail.text = args.matchDetail.scoresDto?.visitorteamScore.toString()
        tvScoreHomeDetailMatchDetail.text = args.matchDetail.scoresDto?.localteamScore.toString()
        tvValueGoalHomeMatchDetail.text = args.matchDetail.goals?.data?.map { it.playerName + " '${it.minute}' " }.toString().dropLast(1).drop(1)

        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

    }

    override fun getViewBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMatchDetailBinding =
        FragmentMatchDetailBinding.inflate(layoutInflater, container, false)

}