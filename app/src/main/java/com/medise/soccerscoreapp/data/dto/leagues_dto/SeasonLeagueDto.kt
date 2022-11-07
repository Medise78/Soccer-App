package com.medise.soccerscoreapp.data.dto.leagues_dto

import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.leagues.SeasonLeague


data class SeasonLeagueDto(
    @SerializedName("data")
    val `data`: SeasonLeagueDataDto
) {
    fun toSeasonLeague(): SeasonLeague {
        return SeasonLeague(
            data = data.toSeasonLeagueData()
        )
    }
}
