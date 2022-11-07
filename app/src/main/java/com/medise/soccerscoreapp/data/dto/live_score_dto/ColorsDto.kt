package com.medise.soccerscoreapp.data.dto.live_score_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.Colors

data class ColorsDto(
    @SerializedName("localteam")
    val localteamDto: LocalteamDto,
    @SerializedName("visitorteam")
    val visitorteamDto: VisitorteamDto
)

fun ColorsDto.toColors():Colors{
    return Colors(
        localteamDto.toLocalTeam(),
        visitorteamDto.toVisitorTeam()
    )
}