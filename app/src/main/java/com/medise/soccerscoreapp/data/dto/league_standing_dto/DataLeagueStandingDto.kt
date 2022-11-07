package com.medise.soccerscoreapp.data.dto.league_standing_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.league_standing.DataLeagueStanding

data class DataLeagueStandingDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("season_id")
    val seasonId: Int?,
    @SerializedName("stage_name")
    val stageName: String?,
    @SerializedName("standings")
    val standingsDto: StandingsDto?,
)

fun DataLeagueStandingDto.toDataLeagueStanding(): DataLeagueStanding {
    return DataLeagueStanding(
        id,
        name,
        seasonId,
        stageName,
        standingsDto?.toStandings()
    )
}