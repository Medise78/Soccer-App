package com.medise.soccerscoreapp.data.dto.live_score_dto

import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.GoalsData

data class GoalsDataDto(
    @SerializedName("extra_minute")
    val extraMinute: Int?,
    @SerializedName("id")
    val id: Long?,
    @SerializedName("minute")
    val minute: Int?,
    @SerializedName("player_assist_name")
    val playerAssistName: String?,
    @SerializedName("player_name")
    val playerName: String?,
    @SerializedName("result")
    val result: String?,
    @SerializedName("type")
    val type: String?
)

fun GoalsDataDto.toGoalsData():GoalsData{
    return GoalsData(
        extraMinute, id, minute, playerAssistName, playerName, result, type
    )
}
