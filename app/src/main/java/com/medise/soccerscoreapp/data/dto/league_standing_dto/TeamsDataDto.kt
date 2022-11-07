package com.medise.soccerscoreapp.data.dto.league_standing_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.league_standing.TeamsData

data class TeamsDataDto(
    @SerializedName("overall")
    val overallDto: OverallDto?,
    @SerializedName("points")
    val points: Int?,
    @SerializedName("position")
    val position: Int?,
    @SerializedName("recent_form")
    val recentForm: String?,
    @SerializedName("result")
    val result: String?,
    @SerializedName("round_name")
    val roundName: Int?,
    @SerializedName("team_id")
    val teamId: Int?,
    @SerializedName("team_name")
    val teamName: String?,
    @SerializedName("team")
    val team: TeamDto?,
    @SerializedName("total")
    val totalDto: TotalDto?
)

fun TeamsDataDto.toTeamsData(): TeamsData {
    return TeamsData(
        overallDto?.toOverall(),
        points,
        position,
        recentForm,
        result,
        roundName,
        teamId,
        teamName,
        totalDto?.toTotal(),
        team?.toTeam()
    )
}