package com.medise.soccerscoreapp.domain.model.league_standing


data class Overall(
    val draw: Int?,
    val gamesPlayed: Int?,
    val goalsAgainst: Int?,
    val goalsScored: Int?,
    val lost: Int?,
    val points: Int?,
    val won: Int?
)
