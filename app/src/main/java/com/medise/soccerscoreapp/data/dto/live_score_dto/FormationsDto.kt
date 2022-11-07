package com.medise.soccerscoreapp.data.dto.live_score_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.Formations

data class FormationsDto(
    @SerializedName("localteam_formation")
    val localteamFormation: String? = null,
    @SerializedName("visitorteam_formation")
    val visitorteamFormation: String? = null
)

fun FormationsDto.formations(): Formations {
    return Formations(
        localteamFormation, visitorteamFormation
    )
}