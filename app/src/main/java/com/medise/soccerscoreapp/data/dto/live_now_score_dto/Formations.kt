package com.medise.soccerscoreapp.data.dto.live_now_score_dto


import com.google.gson.annotations.SerializedName

data class Formations(
    @SerializedName("localteam_formation")
    val localteamFormation: String,
    @SerializedName("visitorteam_formation")
    val visitorteamFormation: String
)