package com.medise.soccerscoreapp.data.dto.leagues_dto

import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.leagues.CountryLeague

data class CountryLeagueDto(
    @SerializedName("data")
    val `data`: CountryLeagueDataDto
){
    fun toCountryLeague(): CountryLeague {
        return CountryLeague(
            data.toCountryLeagueData()
        )
    }
}
