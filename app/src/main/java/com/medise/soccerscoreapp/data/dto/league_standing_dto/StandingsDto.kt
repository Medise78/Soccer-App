package com.medise.soccerscoreapp.data.dto.league_standing_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.league_standing.LeagueStandings

data class StandingsDto(
    @SerializedName("data")
    val `data`: List<TeamsDataDto>
)

fun StandingsDto.toStandings(): LeagueStandings {
    return LeagueStandings(
        data = data.map { it.toTeamsData() }
    )
}
