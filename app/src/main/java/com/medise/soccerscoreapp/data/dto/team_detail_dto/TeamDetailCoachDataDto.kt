package com.medise.soccerscoreapp.data.dto.team_detail_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.team_detail.TeamDetailCoachData

data class TeamDetailCoachDataDto(
    @SerializedName("fullname")
    val fullname: String?,
    @SerializedName("image_path")
    val imagePath: String?,
){
    fun toTeamDetailCoachData():TeamDetailCoachData{
        return TeamDetailCoachData(
            fullname, imagePath
        )
    }
}