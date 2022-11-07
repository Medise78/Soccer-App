package com.medise.soccerscoreapp.data.dto.live_now_score_dto


import com.google.gson.annotations.SerializedName

data class Time(
    @SerializedName("added_time")
    val addedTime: Int,
    @SerializedName("extra_minute")
    val extraMinute: Any,
    @SerializedName("injury_time")
    val injuryTime: Any,
    @SerializedName("minute")
    val minute: Int,
    @SerializedName("second")
    val second: String,
    @SerializedName("starting_at")
    val startingAt: StartingAt,
    @SerializedName("status")
    val status: String
)