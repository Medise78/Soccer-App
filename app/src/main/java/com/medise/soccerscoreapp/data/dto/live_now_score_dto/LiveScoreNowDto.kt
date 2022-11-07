package com.medise.soccerscoreapp.data.dto.live_now_score_dto


import com.google.gson.annotations.SerializedName

data class LiveScoreNowDto(
    @SerializedName("data")
    val `data`: List<Data>
)