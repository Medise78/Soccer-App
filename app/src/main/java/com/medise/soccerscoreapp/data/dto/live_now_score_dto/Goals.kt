package com.medise.soccerscoreapp.data.dto.live_now_score_dto


import com.google.gson.annotations.SerializedName

data class Goals(
    @SerializedName("data")
    val `data`: List<DataX>
)