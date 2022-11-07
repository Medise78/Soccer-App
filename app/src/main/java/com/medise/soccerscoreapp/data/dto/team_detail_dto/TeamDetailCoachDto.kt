package com.medise.soccerscoreapp.data.dto.team_detail_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.team_detail.TeamDetailCoach

data class TeamDetailCoachDto(
    @SerializedName("data")
    val `data`: TeamDetailCoachDataDto
){
    fun toTeamDetailCoach():TeamDetailCoach{
        return TeamDetailCoach(
            data.toTeamDetailCoachData()
        )
    }
}