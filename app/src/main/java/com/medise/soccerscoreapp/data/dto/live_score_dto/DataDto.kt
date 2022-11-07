package com.medise.soccerscoreapp.data.dto.live_score_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.LiveScoreData

data class DataDto(
    @SerializedName("attendance")
    val attendance: Int,
    @SerializedName("coaches")
    val coaches: CoachesDto,
    @SerializedName("colors")
    val colors: ColorsDto,
    @SerializedName("commentaries")
    val commentaries: Boolean,
    @SerializedName("deleted")
    val deleted: Boolean,
    @SerializedName("details")
    val details: Any,
    @SerializedName("formations")
    val formations: FormationsDto,
    @SerializedName("group_id")
    val groupId: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_placeholder")
    val isPlaceholder: Boolean,
    @SerializedName("league_id")
    val leagueId: Int,
    @SerializedName("leg")
    val leg: String,
    @SerializedName("localTeam")
    val localTeam: LocalTeamDetailResultDto,
    @SerializedName("localteam_id")
    val localteamId: Int,
    @SerializedName("neutral_venue")
    val neutralVenue: Boolean,
    @SerializedName("referee_id")
    val refereeId: Int,
    @SerializedName("round_id")
    val roundId: Int,
    @SerializedName("scores")
    val scores: ScoresDto,
    @SerializedName("season_id")
    val seasonId: Int,
    @SerializedName("stage_id")
    val stageId: Int,
    @SerializedName("standings")
    val standings: StandingsDto,
    @SerializedName("time")
    val time: TimeDto,
    @SerializedName("venue_id")
    val venueId: Int,
    @SerializedName("visitorTeam")
    val visitorTeam: VisitorTeamDetailResultDto,
    @SerializedName("visitorteam_id")
    val visitorteamId: Int,
    @SerializedName("winner_team_id")
    val winnerTeamId: Int,
    @SerializedName("winning_odds_calculated")
    val winningOddsCalculated: Boolean,
    @SerializedName("league")
    val league: LiveScoreLeagueDetailDto,
    @SerializedName("visitorCoach")
    val visitorCoach: LiveScoreVisitorCoachDto?,
    @SerializedName("localCoach")
    val localCoach: LiveScoreLocalCoachDto?,
    @SerializedName("goals")
    val goals: GoalsDto,
)

fun DataDto.toData(): LiveScoreData {
    return LiveScoreData(
        localTeam = localTeam.toLocalTeamDetailResult(),
        visitorTeam = visitorTeam.toVisitorTeamDetailResult(),
        id = id,
        coachesDto = coaches.toCoaches(),
        formationsDto = formations.formations(),
        leagueId = leagueId,
        localteamId = localteamId,
        scoresDto = scores.toScores(),
        seasonId = seasonId,
        standingsDto = standings.toStanding(),
        timeDto = time.toTime(),
        visitorteamId = visitorteamId,
        winnerTeamId = winnerTeamId,
        league = league.toLiveScoreLeagueDetail(),
        localCoach = localCoach?.LiveScoreLocalCoach(),
        visitorCoach = visitorCoach?.toLiveScoreVisitorCoach(),
        goals = goals.toGoals()
    )
}