package com.medise.soccerscoreapp.data.dto.team_detail_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.team_detail.TeamDetailCountryData

data class TeamDetailCountryDataDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image_path")
    val imagePath: String?,
    @SerializedName("name")
    val name: String?
){
    fun toTeamDetailCountryData():TeamDetailCountryData{
        return TeamDetailCountryData(
            id, imagePath, name
        )
    }
}