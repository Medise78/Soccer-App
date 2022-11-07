package com.medise.soccerscoreapp.ui.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.medise.soccerscoreapp.R
import com.medise.soccerscoreapp.databinding.ItemFragmentLeaguesBinding
import com.medise.soccerscoreapp.domain.model.leagues.DataLeagues

class LeaguesAdapter(private val context: Context) :
    RecyclerView.Adapter<LeaguesAdapter.LeaguesViewHolder>() {

    inner class LeaguesViewHolder(val binding: ItemFragmentLeaguesBinding) :
        RecyclerView.ViewHolder(binding.root)

    val differCallback = object : DiffUtil.ItemCallback<DataLeagues>() {
        override fun areItemsTheSame(oldItem: DataLeagues, newItem: DataLeagues): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: DataLeagues, newItem: DataLeagues): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallback)

    var leagues: List<DataLeagues>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaguesViewHolder {
        return LeaguesViewHolder(
            ItemFragmentLeaguesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: LeaguesViewHolder, position: Int) {
        val league = leagues[position]

        holder.binding.apply {
            tvLeagueNameFragment.text = league.name
            tvLeagueTypeFragment.text = league.type

            Glide.with(context)
                .load(league.logoPath)
                .into(imgLeagues)

            if (league.liveStandings) {
                imgStatusVector.setImageResource(R.drawable.circle_green)
            } else {
                imgStatusVector.setImageResource(R.drawable.circle_red)
            }
        }

        holder.itemView.setOnClickListener {
            onLeagueClick?.let {
                it(league)
            }
        }
    }

    private var onLeagueClick: ((leagues:DataLeagues) -> Unit)? = null

    fun setOnClickListener(leagues:(DataLeagues) -> Unit) {
        onLeagueClick = leagues
    }

    override fun getItemCount(): Int {
        return leagues.size
    }


}