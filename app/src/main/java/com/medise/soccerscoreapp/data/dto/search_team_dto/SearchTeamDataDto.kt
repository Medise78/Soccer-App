package com.medise.soccerscoreapp.data.dto.search_team_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.data.dto.leagues_dto.CountryLeagueDto
import com.medise.soccerscoreapp.data.dto.leagues_dto.LeaguesDto
import com.medise.soccerscoreapp.data.dto.leagues_dto.toLeagues
import com.medise.soccerscoreapp.data.dto.live_score_dto.LiveScoreLocalCoachDto
import com.medise.soccerscoreapp.domain.model.search_team.SearchTeamData
import com.medise.soccerscoreapp.domain.model.search_team.SearchTeamLeague

data class SearchTeamDataDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("logo_path")
    val logoPath: String?,
    @SerializedName("name")
    val name: String?,
) {
    fun toSearchTeamData(): SearchTeamData {
        return SearchTeamData(

            id = id,
            logoPath = logoPath,
            name = name
        )
    }
}