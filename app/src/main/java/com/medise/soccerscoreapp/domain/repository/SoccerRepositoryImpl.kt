package com.medise.soccerscoreapp.domain.repository

import com.medise.soccerscoreapp.data.ApiService
import com.medise.soccerscoreapp.data.dto.league_standing_dto.toLeagueStanding
import com.medise.soccerscoreapp.data.dto.leagues_dto.toLeagues
import com.medise.soccerscoreapp.data.dto.live_score_dto.toLiveScore
import com.medise.soccerscoreapp.data.repository.SoccerRepository
import com.medise.soccerscoreapp.domain.model.league_standing.LeagueStanding
import com.medise.soccerscoreapp.domain.model.leagues.Leagues
import com.medise.soccerscoreapp.domain.model.live_score.LiveScore
import com.medise.soccerscoreapp.domain.model.search_team.SearchTeam
import com.medise.soccerscoreapp.domain.model.team_detail.TeamDetail
import javax.inject.Inject

class SoccerRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : SoccerRepository {
    override suspend fun getLiveScore(): LiveScore {
        return apiService.getLiveScores().toLiveScore()
    }

    override suspend fun getAllLeague(): Leagues {
        return apiService.getAllLeagues().toLeagues()
    }

    override suspend fun getLeagueStandingById(seasonId: Int): LeagueStanding {
        return apiService.getSeasonStandingById(seasonId).toLeagueStanding()
    }

    override suspend fun searchTeam(teamName: String): SearchTeam {
        return apiService.searchTeamByName(teamName).toSearchTeam()
    }

    override suspend fun getTeamDetailById(id: Int): TeamDetail {
        return apiService.getTeamDetailById(id).toTeamDetail()
    }
}