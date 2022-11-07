package com.medise.soccerscoreapp.data.dto.live_score_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.LocalTeam

data class LocalteamDto(
    @SerializedName("color")
    val color: String,
    @SerializedName("kit_colors")
    val kitColors: String
)

fun LocalteamDto.toLocalTeam(): LocalTeam {
    return LocalTeam(
        color, kitColors
    )
}