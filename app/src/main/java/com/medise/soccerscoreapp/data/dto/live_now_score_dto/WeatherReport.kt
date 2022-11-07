package com.medise.soccerscoreapp.data.dto.live_now_score_dto


import com.google.gson.annotations.SerializedName

data class WeatherReport(
    @SerializedName("clouds")
    val clouds: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("coordinates")
    val coordinates: Coordinates,
    @SerializedName("humidity")
    val humidity: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("temperature")
    val temperature: Temperature,
    @SerializedName("temperature_celcius")
    val temperatureCelcius: TemperatureCelcius,
    @SerializedName("type")
    val type: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("wind")
    val wind: Wind
)