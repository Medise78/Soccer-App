package com.medise.soccerscoreapp.data.dto.live_now_score_dto


import com.google.gson.annotations.SerializedName

data class StartingAt(
    @SerializedName("date")
    val date: String,
    @SerializedName("date_time")
    val dateTime: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("timestamp")
    val timestamp: Int,
    @SerializedName("timezone")
    val timezone: String
)