package com.medise.soccerscoreapp.data.dto.live_now_score_dto


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("coaches")
    val coaches: Coaches,
    @SerializedName("colors")
    val colors: Colors,
    @SerializedName("formations")
    val formations: Formations,
    @SerializedName("goals")
    val goals: Goals,
    @SerializedName("id")
    val id: Int,
    @SerializedName("league_id")
    val leagueId: Int,
    @SerializedName("localteam_id")
    val localteamId: Int,
    @SerializedName("scores")
    val scores: Scores,
    @SerializedName("season_id")
    val seasonId: Int,
    @SerializedName("standings")
    val standings: Standings,
    @SerializedName("time")
    val time: Time,
    @SerializedName("visitorteam_id")
    val visitorteamId: Int,
    @SerializedName("winner_team_id")
    val winnerTeamId: Int,
)