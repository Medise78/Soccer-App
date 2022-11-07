package com.medise.soccerscoreapp.data.dto.league_standing_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.league_standing.LeagueStanding

data class LeagueStandingDto(
    @SerializedName("data")
    val `data`: List<DataLeagueStandingDto>,
)

fun LeagueStandingDto.toLeagueStanding(): LeagueStanding {
    return LeagueStanding(
        data = data.map { it.toDataLeagueStanding() }
    )
}

