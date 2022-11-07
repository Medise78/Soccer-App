package com.medise.soccerscoreapp.data.dto.team_detail_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.team_detail.TeamDetail

data class TeamDetailDto(
    @SerializedName("data")
    val `data`: TeamDetailDataDto
){
    fun toTeamDetail():TeamDetail{
        return TeamDetail(
            data.toTeamDetailData()
        )
    }
}