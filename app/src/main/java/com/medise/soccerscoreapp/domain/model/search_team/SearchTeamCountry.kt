package com.medise.soccerscoreapp.domain.model.search_team



data class SearchTeamCountry(
    val `data`: SearchTeamCountryData?
)

data class SearchTeamCountryData(
    val id: Int?,
    val imagePath: String?,
    val name: String?
)
