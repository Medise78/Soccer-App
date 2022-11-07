package com.medise.soccerscoreapp.data.dto.live_now_score_dto


import com.google.gson.annotations.SerializedName

data class Coaches(
    @SerializedName("localteam_coach_id")
    val localteamCoachId: Int,
    @SerializedName("visitorteam_coach_id")
    val visitorteamCoachId: Int
)