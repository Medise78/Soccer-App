package com.medise.soccerscoreapp.data.dto.live_score_dto

import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.VisitorTeamDetailResult

data class VisitorTeamDetailResultDto(
    @SerializedName("data")
    val `data`: VisitorTeamDetailDto
)

fun VisitorTeamDetailResultDto.toVisitorTeamDetailResult(): VisitorTeamDetailResult {
    return VisitorTeamDetailResult(
        data = data.toVisitorTeamDetail()
    )
}
