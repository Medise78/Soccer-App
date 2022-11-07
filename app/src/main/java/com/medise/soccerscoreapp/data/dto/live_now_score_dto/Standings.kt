package com.medise.soccerscoreapp.data.dto.live_now_score_dto


import com.google.gson.annotations.SerializedName

data class Standings(
    @SerializedName("localteam_position")
    val localteamPosition: Int,
    @SerializedName("visitorteam_position")
    val visitorteamPosition: Int
)