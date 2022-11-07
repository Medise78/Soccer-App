package com.medise.soccerscoreapp.data.repository

import com.medise.soccerscoreapp.domain.model.league_standing.LeagueStanding
import com.medise.soccerscoreapp.domain.model.leagues.Leagues
import com.medise.soccerscoreapp.domain.model.live_score.LiveScore
import com.medise.soccerscoreapp.domain.model.search_team.SearchTeam
import com.medise.soccerscoreapp.domain.model.team_detail.TeamDetail

interface SoccerRepository {
    suspend fun getLiveScore(): LiveScore
    suspend fun getAllLeague(): Leagues
    suspend fun getLeagueStandingById(seasonId: Int): LeagueStanding
    suspend fun searchTeam(teamName: String): SearchTeam
    suspend fun getTeamDetailById(id: Int): TeamDetail
}