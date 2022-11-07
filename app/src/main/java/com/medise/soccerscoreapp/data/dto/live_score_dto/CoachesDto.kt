package com.medise.soccerscoreapp.data.dto.live_score_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.Coaches

data class CoachesDto(
    @SerializedName("localteam_coach_id")
    val localteamCoachId: Int,
    @SerializedName("visitorteam_coach_id")
    val visitorteamCoachId: Int
)

fun CoachesDto.toCoaches(): Coaches {
    return Coaches(
        localteamCoachId, visitorteamCoachId
    )
}