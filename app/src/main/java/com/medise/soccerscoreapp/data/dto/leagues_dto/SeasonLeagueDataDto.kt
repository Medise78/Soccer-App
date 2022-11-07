package com.medise.soccerscoreapp.data.dto.leagues_dto

import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.leagues.SeasonLeagueData

data class SeasonLeagueDataDto(
    @SerializedName("name")
    val name: String
){
    fun toSeasonLeagueData(): SeasonLeagueData {
        return SeasonLeagueData(
            name
        )
    }
}
