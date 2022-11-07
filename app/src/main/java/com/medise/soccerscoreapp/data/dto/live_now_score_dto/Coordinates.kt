package com.medise.soccerscoreapp.data.dto.live_now_score_dto


import com.google.gson.annotations.SerializedName

data class Coordinates(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
)