package com.medise.soccerscoreapp.data.dto.live_score_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.Scores

data class ScoresDto(
    @SerializedName("et_score")
    val etScore: String? = null,
    @SerializedName("ft_score")
    val ftScore: String? = null,
    @SerializedName("ht_score")
    val htScore: String? = null,
    @SerializedName("localteam_score")
    val localteamScore: Int,
    @SerializedName("visitorteam_score")
    val visitorteamScore: Int
)

fun ScoresDto.toScores(): Scores {
    return Scores(
        etScore, ftScore, htScore, localteamScore, visitorteamScore
    )
}