package com.medise.soccerscoreapp.data.dto.live_now_score_dto


import com.google.gson.annotations.SerializedName

data class Colors(
    @SerializedName("localteam")
    val localteam: Localteam,
    @SerializedName("visitorteam")
    val visitorteam: Visitorteam
)