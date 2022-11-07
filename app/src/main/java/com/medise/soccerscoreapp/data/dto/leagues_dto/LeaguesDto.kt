package com.medise.soccerscoreapp.data.dto.leagues_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.leagues.Leagues

data class LeaguesDto(
    @SerializedName("data")
    val `data`: List<DataLeaguesDto>,
)

fun LeaguesDto.toLeagues(): Leagues {
    return Leagues(
        data = data.map { it.toDataLeagues() }
    )
}