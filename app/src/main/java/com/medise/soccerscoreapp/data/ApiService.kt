package com.medise.soccerscoreapp.data

import com.medise.soccerscoreapp.data.dto.league_standing_dto.LeagueStandingDto
import com.medise.soccerscoreapp.data.dto.leagues_dto.LeaguesDto
import com.medise.soccerscoreapp.data.dto.live_score_dto.LiveScoreDto
import com.medise.soccerscoreapp.data.dto.search_team_dto.SearchTeamDto
import com.medise.soccerscoreapp.data.dto.team_detail_dto.TeamDetailDto
import com.medise.soccerscoreapp.util.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("api/v2.0/livescores")
    suspend fun getLiveScores(
        @Query("api_token") apiToken: String = Constants.API_KEY,
        @Query("include") include: String = Constants.liveScoreInclude,
        @Query("tz") tz: String = Constants.timeZone
    ): LiveScoreDto

    @GET("api/v2.0/leagues")
    suspend fun getAllLeagues(
        @Query("api_token") apiToken: String = Constants.API_KEY,
        @Query("include") include: String = Constants.leagueInclude
    ): LeaguesDto

    @GET("api/v2.0/standings/season/{season_id}")
    suspend fun getSeasonStandingById(
        @Path("season_id") seasonId: Int,
        @Query("api_token") apiToken: String = Constants.API_KEY,
        @Query("include") include: String = Constants.leagueStandingInclude,
    ): LeagueStandingDto

    @GET("api/v2.0/teams/search/{team_name}")
    suspend fun searchTeamByName(
        @Path("team_name") teamName: String,
        @Query("api_token") apiToken: String = Constants.API_KEY
    ): SearchTeamDto

    @GET("api/v2.0/teams/{id}")
    suspend fun getTeamDetailById(
        @Path("id") teamId: Int,
        @Query("api_token") apiToken: String = Constants.API_KEY,
        @Query("include") include: String = Constants.searchTeamInclude
    ): TeamDetailDto
}