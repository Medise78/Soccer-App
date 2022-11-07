package com.medise.soccerscoreapp.data.dto.live_score_dto

import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.LiveScoreLeagueDetail

data class LiveScoreLeagueDetailDto(
    @SerializedName("data")
    val `data`: LiveScoreLeagueDataDto
)

fun LiveScoreLeagueDetailDto.toLiveScoreLeagueDetail(): LiveScoreLeagueDetail {
    return LiveScoreLeagueDetail(data.toLiveScoreLeagueData())
}
