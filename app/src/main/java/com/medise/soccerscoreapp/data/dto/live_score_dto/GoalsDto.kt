package com.medise.soccerscoreapp.data.dto.live_score_dto

import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.Goals


data class GoalsDto(
    @SerializedName("data")
    val `data`: List<GoalsDataDto>
)

fun GoalsDto.toGoals(): Goals {
    return Goals(
        data = data.map { it.toGoalsData() }
    )
}
