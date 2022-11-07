package com.medise.soccerscoreapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.medise.soccerscoreapp.databinding.TeamsNameItemBinding
import com.medise.soccerscoreapp.domain.model.search_team.SearchTeamData

class TeamsNameAdapter(
    private val context: Context
) : RecyclerView.Adapter<TeamsNameAdapter.TeamsNameViewHolder>() {

    inner class TeamsNameViewHolder(val binding: TeamsNameItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallBack = object : DiffUtil.ItemCallback<SearchTeamData>() {
        override fun areItemsTheSame(oldItem: SearchTeamData, newItem: SearchTeamData): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: SearchTeamData, newItem: SearchTeamData): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallBack)

    var teams: List<SearchTeamData>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsNameViewHolder {
        return TeamsNameViewHolder(
            TeamsNameItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TeamsNameViewHolder, position: Int) {
        val team = teams[position]
        holder.binding.apply {
            teamNameItem.text = team.name
            Glide.with(context)
                .load(team.logoPath)
                .into(imgTeamsName)
        }
        holder.itemView.setOnClickListener {
            onClick?.let {
                it(team.id!!)
            }
        }
    }

    override fun getItemCount(): Int {
        return teams.size
    }


    private var onClick:((Int) -> Unit)? = null

    fun onClickListener(teamId:(Int) -> Unit){
        onClick = teamId
    }
}