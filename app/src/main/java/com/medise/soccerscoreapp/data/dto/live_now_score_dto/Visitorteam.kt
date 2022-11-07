package com.medise.soccerscoreapp.data.dto.live_now_score_dto


import com.google.gson.annotations.SerializedName

data class Visitorteam(
    @SerializedName("color")
    val color: String,
    @SerializedName("kit_colors")
    val kitColors: String
)