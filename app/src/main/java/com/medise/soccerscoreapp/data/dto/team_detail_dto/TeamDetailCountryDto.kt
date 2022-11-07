package com.medise.soccerscoreapp.data.dto.team_detail_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.team_detail.TeamDetailCountry

data class TeamDetailCountryDto(
    @SerializedName("data")
    val `data`: TeamDetailCountryDataDto?
){
    fun toTeamDetailCountry():TeamDetailCountry{
        return TeamDetailCountry(
            data?.toTeamDetailCountryData()
        )
    }
}