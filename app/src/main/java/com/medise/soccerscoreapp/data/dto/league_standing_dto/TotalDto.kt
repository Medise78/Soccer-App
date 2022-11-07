package com.medise.soccerscoreapp.data.dto.league_standing_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.league_standing.Total

data class TotalDto(
    @SerializedName("goal_difference")
    val goalDifference: String?,
    @SerializedName("points")
    val points: Int?
)

fun TotalDto.toTotal(): Total {
    return Total(goalDifference, points)
}