package com.medise.soccerscoreapp.data.dto.live_now_score_dto


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("extra_minute")
    val extraMinute: Any,
    @SerializedName("fixture_id")
    val fixtureId: Int,
    @SerializedName("id")
    val id: Long,
    @SerializedName("minute")
    val minute: Int,
    @SerializedName("player_assist_id")
    val playerAssistId: Int,
    @SerializedName("player_assist_name")
    val playerAssistName: String,
    @SerializedName("player_id")
    val playerId: Int,
    @SerializedName("player_name")
    val playerName: String,
    @SerializedName("reason")
    val reason: Any,
    @SerializedName("result")
    val result: String,
    @SerializedName("team_id")
    val teamId: String,
    @SerializedName("type")
    val type: String
)