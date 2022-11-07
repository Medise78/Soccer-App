package com.medise.soccerscoreapp.domain.model.team_detail


data class TeamDetailCountry(
    val `data`: TeamDetailCountryData?
)

data class TeamDetailCountryData(
    val id: Int?,
    val imagePath: String?,
    val name: String?
)
