package com.medise.soccerscoreapp.domain.model.team_detail


data class TeamDetailLeague(
    val `data`: TeamDetailLeagueData?
)

data class TeamDetailLeagueData(
    val logoPath: String?,
    val name: String?,
)
