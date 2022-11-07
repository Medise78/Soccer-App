package com.medise.soccerscoreapp.data.dto.live_now_score_dto


import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("degree")
    val degree: Int,
    @SerializedName("speed")
    val speed: String
)