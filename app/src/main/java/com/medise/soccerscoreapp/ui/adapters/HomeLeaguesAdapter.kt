package com.medise.soccerscoreapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.medise.soccerscoreapp.databinding.ItemLeagueBinding
import com.medise.soccerscoreapp.domain.model.leagues.DataLeagues

class HomeLeaguesAdapter(private val context: Context) :
    RecyclerView.Adapter<HomeLeaguesAdapter.HomeLeagueViewHolder>() {

    inner class HomeLeagueViewHolder(val binding: ItemLeagueBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<DataLeagues>() {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeLeagueViewHolder {
        return HomeLeagueViewHolder(
            ItemLeagueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomeLeagueViewHolder, position: Int) {
        val league = leagues[position]
        holder.binding.apply {
            Glide.with(context)
                .load(league.logoPath)
                .into(imgLeagues)
            tvLeagueName.text = league.name
        }

        holder.itemView.setOnClickListener {
            setOnClick?.let {
                it(league)
            }
        }
    }

    override fun getItemCount(): Int {
        return leagues.size
    }

    private var setOnClick:((league:DataLeagues) -> Unit)? = null

    fun setOnClickListener(league: (DataLeagues) -> Unit){
        setOnClick = league
    }

}