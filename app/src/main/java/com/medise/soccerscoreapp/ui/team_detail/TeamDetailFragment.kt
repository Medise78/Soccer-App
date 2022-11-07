package com.medise.soccerscoreapp.ui.team_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.medise.soccerscoreapp.R
import com.medise.soccerscoreapp.databinding.FragmentTeamDetailBinding
import com.medise.soccerscoreapp.ui.base_fragment.BaseFragment
import com.medise.soccerscoreapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TeamDetailFragment : BaseFragment<FragmentTeamDetailBinding, TeamDetailViewModel>() {
    override val viewModel: TeamDetailViewModel by viewModels()

    private val args:TeamDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        args.teamId
        observerData()
    }


    private fun observerData() = lifecycleScope.launch {
        viewModel.getTeamDetail.collect { resource ->
            when (resource) {
                is Resource.Loading -> {

                }
                is Resource.Error -> {

                }
                is Resource.Success -> {
                    resource.data?.let {

                        binding.apply {
                            tvTeamNameTeamDetail.text = if (it.data.shortCode?.isNotEmpty() == true) "${it.data.name} (${it.data.shortCode})" else "${it.data.name}"
                            tvLeagueNameTeamDetail.text = it.data.teamDetailLeagueDto?.data?.name
                            tvValueSportTeamDetail.text = it.data.teamDetailCoachDto?.data?.fullname
                            tvValueYearTeamDetail.text = it.data.founded?.toString()
                            tvValueUEFATeamDetail.text = it.data.UEFARankingDto?.data?.position?.toString()
                            tvValueTwitterTeamDetail.text = it.data.twitter
                            Glide.with(requireContext())
                                .load(it.data.teamDetailCountryDto?.data?.imagePath)
                                .into(imgValueCountryTeamDetail)

                            Glide.with(requireContext())
                                .load(it.data.logoPath)
                                .into(imgTeamLogo)

                            toolbar.setNavigationOnClickListener {
                                findNavController().navigateUp()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun getViewBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTeamDetailBinding =
        FragmentTeamDetailBinding.inflate(layoutInflater, container, false)
}