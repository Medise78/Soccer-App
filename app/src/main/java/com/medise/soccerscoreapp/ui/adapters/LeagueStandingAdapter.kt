package com.medise.soccerscoreapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.medise.soccerscoreapp.databinding.ItemStandingBinding
import com.medise.soccerscoreapp.domain.model.league_standing.TeamsData

class LeagueStandingAdapter(private val context: Context) :
    RecyclerView.Adapter<LeagueStandingAdapter.LeagueStandingViewHolder>() {

    inner class LeagueStandingViewHolder(val binding: ItemStandingBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<TeamsData>() {
        override fun areItemsTheSame(oldItem: TeamsData, newItem: TeamsData): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: TeamsData, newItem: TeamsData): Boolean {
            return oldItem == newItem
        }

    }

    private var differ = AsyncListDiffer(this, differCallback)

    var standingLeague: List<TeamsData?>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueStandingViewHolder {
        return LeagueStandingViewHolder(
            ItemStandingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: LeagueStandingViewHolder, position: Int) {
        val league = standingLeague[position]
        holder.binding.apply {
            if (league != null) {
                tvTeamName.text = league.teamName
                tvPlayed.text = league.overallDto?.gamesPlayed.toString()
                tvDraw.text = league.overallDto?.draw.toString()
                tvGK.text = league.overallDto?.goalsAgainst.toString()
                tvLose.text = league.overallDto?.lost.toString()
                tvWin.text = league.overallDto?.won.toString()
                Glide.with(context)
                    .load(league.team?.data?.logoPath)
                    .into(imgTeamStanding)
            } else {
                tvTeamName.text = ""
                tvPlayed.text = ""
                tvDraw.text = ""
                tvGK.text = ""
                tvLose.text = ""
                tvWin.text = ""
            }



        }
    }

    override fun getItemCount(): Int {
        return standingLeague.size
    }

}