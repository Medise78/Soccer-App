package com.medise.soccerscoreapp.data.dto.live_score_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.StartingAt

data class StartingAtDto(
    @SerializedName("date")
    val date: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("timezone")
    val timezone: String
)

fun StartingAtDto.toStartingAt():StartingAt{
    return StartingAt(
        date, time, timezone
    )
}