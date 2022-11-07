package com.medise.soccerscoreapp.data.dto.leagues_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.leagues.DataLeagues

data class DataLeaguesDto(
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("current_season_id")
    val currentSeasonId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("live_standings")
    val liveStandings: Boolean,
    @SerializedName("logo_path")
    val logoPath: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("season")
    val season: SeasonLeagueDto,
    @SerializedName("country")
    val country: CountryLeagueDto,
)

fun DataLeaguesDto.toDataLeagues(): DataLeagues {
    return DataLeagues(
        active,
        currentSeasonId,
        id,
        liveStandings,
        logoPath,
        name,
        type,
        season.toSeasonLeague(),
        country.toCountryLeague()
    )
}