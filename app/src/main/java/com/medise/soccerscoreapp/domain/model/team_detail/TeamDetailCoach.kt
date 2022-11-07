package com.medise.soccerscoreapp.domain.model.team_detail


data class TeamDetailCoach(
    val `data`: TeamDetailCoachData?
)

data class TeamDetailCoachData(
    val fullname: String?,
    val imagePath: String?,
)
