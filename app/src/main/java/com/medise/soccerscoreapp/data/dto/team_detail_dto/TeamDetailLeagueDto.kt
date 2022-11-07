package com.medise.soccerscoreapp.data.dto.team_detail_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.team_detail.TeamDetailLeague

data class TeamDetailLeagueDto(
    @SerializedName("data")
    val `data`: TeamDetailLeagueDataDto?
){
    fun toTeamDetailLeague():TeamDetailLeague{
        return TeamDetailLeague(
            data?.toTeamDetailLeagueData()
        )
    }
}