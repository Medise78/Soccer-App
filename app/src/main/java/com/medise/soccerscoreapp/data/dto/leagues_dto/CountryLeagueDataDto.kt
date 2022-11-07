package com.medise.soccerscoreapp.data.dto.leagues_dto

import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.leagues.CountryLeagueData

data class CountryLeagueDataDto(
    @SerializedName("image_path")
    val imagePath: String,
    @SerializedName("name")
    val name: String
){
    fun toCountryLeagueData(): CountryLeagueData {
        return CountryLeagueData(
            imagePath, name
        )
    }
}
