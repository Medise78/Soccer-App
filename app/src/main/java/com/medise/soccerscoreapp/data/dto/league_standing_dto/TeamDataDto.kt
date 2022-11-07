package com.medise.soccerscoreapp.data.dto.league_standing_dto

import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.league_standing.TeamData

data class TeamDataDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("logo_path")
    val logoPath: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("short_code")
    val shortCode: String?,
){
    fun toTeamData():TeamData{
        return TeamData(
            id, logoPath, name, shortCode
        )
    }
}
