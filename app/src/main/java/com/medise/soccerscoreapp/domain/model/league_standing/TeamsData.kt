package com.medise.soccerscoreapp.domain.model.league_standing


data class TeamsData(
    val overallDto: Overall?,
    val points: Int?,
    val position: Int?,
    val recentForm: String?,
    val result: String?,
    val roundName: Int?,
    val teamId: Int?,
    val teamName: String?,
    val totalDto: Total?,
    val team: Team?
)

data class Team(
    val `data`: TeamData?
)

data class TeamData(
    val id: Int?,
    val logoPath: String?,
    val name: String?,
    val shortCode: String?,
)
