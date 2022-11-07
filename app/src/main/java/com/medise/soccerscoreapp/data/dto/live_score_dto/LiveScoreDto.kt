package com.medise.soccerscoreapp.data.dto.live_score_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.LiveScore

data class LiveScoreDto(
    @SerializedName("data")
    val `data`: List<DataDto> ? = emptyList(),
)

fun LiveScoreDto.toLiveScore(): LiveScore {
    return LiveScore(
        data = data?.map { it.toData() }
    )
}