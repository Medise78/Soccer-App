package com.medise.soccerscoreapp.data.dto.live_score_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.VisitorTeam

data class VisitorteamDto(
    @SerializedName("color")
    val color: String,
    @SerializedName("kit_colors")
    val kitColors: String
)

fun VisitorteamDto.toVisitorTeam(): VisitorTeam {
    return VisitorTeam(
        color, kitColors
    )
}