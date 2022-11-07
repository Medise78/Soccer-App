package com.medise.soccerscoreapp.domain.model.league_standing


data class DataLeagueStanding(
    val id: Int?,
    val name: String?,
    val seasonId: Int?,
    val stageName: String?,
    val leagueStandingsDto: LeagueStandings?,
)
