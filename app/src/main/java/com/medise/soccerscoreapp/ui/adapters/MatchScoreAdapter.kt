package com.medise.soccerscoreapp.ui.adapters

import android.app.AlertDialog
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.medise.soccerscoreapp.R
import com.medise.soccerscoreapp.databinding.ItemMatchBinding
import com.medise.soccerscoreapp.domain.model.live_score.LiveScoreData
import kotlinx.android.synthetic.main.custom_alert_dialog.view.*

class MatchScoreAdapter(private val context: Context) :
    RecyclerView.Adapter<MatchScoreAdapter.MatchScoreViewHolder>() {


    inner class MatchScoreViewHolder(val binding: ItemMatchBinding) :
        RecyclerView.ViewHolder(binding.root)

    val differCallback = object : DiffUtil.ItemCallback<LiveScoreData>() {
        override fun areItemsTheSame(oldItem: LiveScoreData, newItem: LiveScoreData): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: LiveScoreData, newItem: LiveScoreData): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    var matches: List<LiveScoreData>
        get() = differ.currentList
        set(value) = differ.submitList(value)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchScoreViewHolder {
        return MatchScoreViewHolder(
            ItemMatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: MatchScoreViewHolder, position: Int) {
        val match = matches[position]

        holder.binding.apply {
            tvLeagueName.text = match.league?.data?.name
            tvMatchDate.text = match.timeDto?.startingAtDto?.time
            tvScoreHome.text = match.scoresDto?.localteamScore.toString()
            tvScoreAway.text = match.scoresDto?.visitorteamScore.toString()
            tvTeamHomeName.text = match.localTeam?.data?.name
            tvTeamAwayName.text = match.visitorTeam?.data?.name

            Glide.with(context)
                .load(match.localTeam!!.data.logoPath)
                .into(imgTeamHome)

            Glide.with(context)
                .load(match.visitorTeam!!.data.logoPath)
                .into(imgTeamAway)

            Glide.with(context)
                .load(match.league?.data?.logoPath)
                .into(imgLeague)

            imgTeamHome.setOnClickListener {
                showHomeDialog(match)
            }

            imgTeamAway.setOnClickListener {
                showAwayDialog(match)
            }
        }

        holder.itemView.setOnClickListener {
            setOnClick?.let {
                it(match)
            }
        }

    }

    private fun showHomeDialog(liveScoreData: LiveScoreData) {
        val builder = AlertDialog.Builder(context, R.style.CustomAlertDialog)
            .create()
        val view = LayoutInflater.from(context).inflate(R.layout.custom_alert_dialog, null)
        view.tvDialog.text = liveScoreData.localTeam?.data?.name
        if (liveScoreData.localTeam?.data?.shortCode != null) {
            view.tvShortNameDialog.text = "(${liveScoreData.localTeam.data.shortCode})"
        } else {
            view.tvShortNameDialog.text = ""
        }
        view.tvLeagueNameDialog.text = liveScoreData.league?.data?.name
        if (liveScoreData.formationsDto?.localteamFormation != null) {
            view.tvFormationDialog.text =
                "Formation: ${liveScoreData.formationsDto.localteamFormation}"
        } else {
            view.tvFormationDialog.text = ""
        }

        view.tvCoachName.text = liveScoreData.localCoach?.data?.fullname

        view.tvLeagueStandingDialog.text =
            "League Pos: #${liveScoreData.standingsDto?.localteamPosition}"

        if (liveScoreData.localCoach?.data?.imagePath != null) {
            Glide.with(context)
                .load(liveScoreData.localCoach.data.imagePath)
                .into(view.imgCoach)
        } else {

        }
        Glide.with(context)
            .load(liveScoreData.league?.data?.logoPath)
            .into(view.imgLeagueDialog)

        Glide.with(context)
            .load(liveScoreData.localTeam?.data?.logoPath)
            .into(view.imgDialog)
        builder.setView(view)
        builder.setCanceledOnTouchOutside(true)
        builder.show()
    }

    private fun showAwayDialog(liveScoreData: LiveScoreData) {
        val builder = AlertDialog.Builder(context, R.style.CustomAlertDialog)
            .create()
        val view = LayoutInflater.from(context).inflate(R.layout.custom_alert_dialog, null)
        view.tvDialog.text = liveScoreData.visitorTeam?.data?.name
        if (liveScoreData.visitorTeam?.data?.shortCode != null) {
            view.tvShortNameDialog.text = "(${liveScoreData.visitorTeam.data.shortCode})"
        } else {
            view.tvShortNameDialog.text = ""
        }
        view.tvLeagueNameDialog.text = liveScoreData.league?.data?.name
        if (liveScoreData.formationsDto?.visitorteamFormation != null) {
            view.tvFormationDialog.text =
                "Formation: ${liveScoreData.formationsDto.visitorteamFormation}"
        } else {
            view.tvFormationDialog.text = ""
        }

        view.tvCoachName.text = liveScoreData.visitorCoach?.data?.fullname

        view.tvLeagueStandingDialog.text =
            "League Pos: #${liveScoreData.standingsDto?.visitorteamPosition}"

        if (liveScoreData.visitorCoach?.data?.imagePath != null) {
            Glide.with(context)
                .load(liveScoreData.visitorCoach.data.imagePath)
                .into(view.imgCoach)
        } else {

        }
        Glide.with(context)
            .load(liveScoreData.league?.data?.logoPath)
            .into(view.imgLeagueDialog)

        Glide.with(context)
            .load(liveScoreData.visitorTeam?.data?.logoPath)
            .into(view.imgDialog)
        builder.setView(view)
        builder.setCanceledOnTouchOutside(true)
        builder.show()
    }

    private var setOnClick: ((LiveScoreData) -> Unit)? = null

    fun setonClickListener(match:(LiveScoreData) -> Unit){
        setOnClick = match
    }

    override fun getItemCount(): Int = matches.size
}