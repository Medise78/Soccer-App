package com.medise.soccerscoreapp.data.dto.league_standing_dto

import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.league_standing.Team

data class TeamDto(
    @SerializedName("data")
    val `data`: TeamDataDto?
) {
    fun toTeam(): Team {
        return Team(
            data?.toTeamData()
        )
    }
}
