package com.medise.soccerscoreapp.domain.model.search_team



data class SearchTeamLeague(
    val `data`: SearchTeamLeagueData?
)


data class SearchTeamLeagueData(
    val logoPath: String?,
    val name: String?,
)