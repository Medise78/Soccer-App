package com.medise.soccerscoreapp.domain.model.leagues


data class CountryLeague(
    val `data`: CountryLeagueData
)

data class CountryLeagueData(
    val imagePath: String,
    val name: String
)
