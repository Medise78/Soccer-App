package com.medise.soccerscoreapp.data.dto.live_score_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.Time

data class TimeDto(
    @SerializedName("added_time")
    val addedTime: Int,
    @SerializedName("extra_minute")
    val extraMinute: Int,
    @SerializedName("minute")
    val minute: Int,
    @SerializedName("second")
    val second: Int,
    @SerializedName("starting_at")
    val startingAtDto: StartingAtDto,
)

fun TimeDto.toTime(): Time {
    return Time(
        addedTime, extraMinute, minute, second, startingAtDto.toStartingAt()
    )
}