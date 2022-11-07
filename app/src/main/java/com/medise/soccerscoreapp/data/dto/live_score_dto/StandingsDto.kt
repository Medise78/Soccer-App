package com.medise.soccerscoreapp.data.dto.live_score_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.Standings

data class StandingsDto(
    @SerializedName("localteam_position")
    val localteamPosition: Int,
    @SerializedName("visitorteam_position")
    val visitorteamPosition: Int
)

fun StandingsDto.toStanding(): Standings {
    return Standings(
        localteamPosition, visitorteamPosition
    )
}