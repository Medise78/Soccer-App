package com.medise.soccerscoreapp.data.dto.team_detail_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.team_detail.TeamDetailLeagueData

data class TeamDetailLeagueDataDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("logo_path")
    val logoPath: String?,
    @SerializedName("name")
    val name: String?,
){
    fun toTeamDetailLeagueData():TeamDetailLeagueData{
        return TeamDetailLeagueData(
            name = name,
            logoPath = logoPath
        )
    }
}