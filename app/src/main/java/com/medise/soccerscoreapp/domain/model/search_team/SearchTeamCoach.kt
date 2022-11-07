package com.medise.soccerscoreapp.domain.model.search_team



data class SearchTeamCoach(
    val `data`: SearchTeamCoachData?
)

data class SearchTeamCoachData(
    val fullname: String?,
    val imagePath: String?,
)
