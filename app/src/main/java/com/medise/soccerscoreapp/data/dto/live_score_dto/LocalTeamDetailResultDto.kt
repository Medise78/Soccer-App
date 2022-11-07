package com.medise.soccerscoreapp.data.dto.live_score_dto

import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.LocalTeamDetailResult

data class LocalTeamDetailResultDto(
    @SerializedName("data")
    val `data`: LocalTeamDetailDto
)

fun LocalTeamDetailResultDto.toLocalTeamDetailResult():LocalTeamDetailResult{
    return LocalTeamDetailResult(
        data = data.toLocalTeamDetail()
    )
}
