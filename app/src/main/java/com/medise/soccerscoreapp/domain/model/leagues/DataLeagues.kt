package com.medise.soccerscoreapp.domain.model.leagues

import java.io.Serializable


data class DataLeagues(
    val active: Boolean,
    val currentSeasonId: Int,
    val id: Int,
    val liveStandings: Boolean,
    val logoPath: String,
    val name: String,
    val type: String,
    val season: SeasonLeague,
    val country: CountryLeague
):Serializable
