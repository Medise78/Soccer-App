package com.medise.soccerscoreapp.data.dto.live_now_score_dto


import com.google.gson.annotations.SerializedName

data class TemperatureCelcius(
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("unit")
    val unit: String
)