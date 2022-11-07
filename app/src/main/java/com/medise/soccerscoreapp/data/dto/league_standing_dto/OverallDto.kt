package com.medise.soccerscoreapp.data.dto.league_standing_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.league_standing.Overall

data class OverallDto(
    @SerializedName("draw")
    val draw: Int?,
    @SerializedName("games_played")
    val gamesPlayed: Int?,
    @SerializedName("goals_against")
    val goalsAgainst: Int?,
    @SerializedName("goals_scored")
    val goalsScored: Int?,
    @SerializedName("lost")
    val lost: Int?,
    @SerializedName("points")
    val points: Int?,
    @SerializedName("won")
    val won: Int?
)

fun OverallDto.toOverall(): Overall {
    return Overall(
        draw, gamesPlayed, goalsAgainst, goalsScored, lost, points, won
    )
}