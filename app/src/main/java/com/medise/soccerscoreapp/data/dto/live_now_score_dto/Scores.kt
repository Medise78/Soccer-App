package com.medise.soccerscoreapp.data.dto.live_now_score_dto


import com.google.gson.annotations.SerializedName

data class Scores(
    @SerializedName("et_score")
    val etScore: Any,
    @SerializedName("ft_score")
    val ftScore: String,
    @SerializedName("ht_score")
    val htScore: String,
    @SerializedName("localteam_pen_score")
    val localteamPenScore: Any,
    @SerializedName("localteam_score")
    val localteamScore: Int,
    @SerializedName("ps_score")
    val psScore: Any,
    @SerializedName("visitorteam_pen_score")
    val visitorteamPenScore: Any,
    @SerializedName("visitorteam_score")
    val visitorteamScore: Int
)