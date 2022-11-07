package com.medise.soccerscoreapp.data.dto.live_score_dto

import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.LocalTeamDetail

data class LocalTeamDetailDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo_path")
    val logoPath: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("short_code")
    val shortCode: String?=null,
)

fun LocalTeamDetailDto.toLocalTeamDetail():LocalTeamDetail{
    return LocalTeamDetail(
        id, logoPath, name, shortCode
    )
}
