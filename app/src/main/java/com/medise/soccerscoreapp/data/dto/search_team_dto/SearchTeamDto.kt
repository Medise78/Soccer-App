package com.medise.soccerscoreapp.data.dto.search_team_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.search_team.SearchTeam

data class SearchTeamDto(
    @SerializedName("data")
    val `data`: List<SearchTeamDataDto>,
){
    fun toSearchTeam():SearchTeam{
        return SearchTeam(
            data = data.map { it.toSearchTeamData() }
        )
    }
}