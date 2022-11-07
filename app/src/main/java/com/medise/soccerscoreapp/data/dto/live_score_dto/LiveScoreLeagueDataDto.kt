package com.medise.soccerscoreapp.data.dto.live_score_dto

import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.LiveScoreLeagueData

data class LiveScoreLeagueDataDto(
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("current_season_id")
    val currentSeasonId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo_path")
    val logoPath: String,
    @SerializedName("name")
    val name: String,
)

fun LiveScoreLeagueDataDto.toLiveScoreLeagueData():LiveScoreLeagueData{
    return LiveScoreLeagueData(
        active, currentSeasonId, id, logoPath, name
    )
}
