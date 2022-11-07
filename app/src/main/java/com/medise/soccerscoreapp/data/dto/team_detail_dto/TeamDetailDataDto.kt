package com.medise.soccerscoreapp.data.dto.team_detail_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.team_detail.TeamDetailData

data class TeamDetailDataDto(
    @SerializedName("coach")
    val teamDetailCoachDto: TeamDetailCoachDto?,
    @SerializedName("country")
    val teamDetailCountryDto: TeamDetailCountryDto?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("league")
    val teamDetailLeagueDto: TeamDetailLeagueDto?,
    @SerializedName("logo_path")
    val logoPath: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("short_code")
    val shortCode: String?,
    @SerializedName("twitter")
    val twitter: String?,
    @SerializedName("uefaranking")
    val UEFARankingDto: UEFARankingDto?,
    @SerializedName("founded")
    val founded:Int?
){
    fun toTeamDetailData():TeamDetailData{
        return TeamDetailData(
            logoPath = logoPath,
            name = name,
            shortCode = shortCode,
            id = id,
            teamDetailCoachDto = teamDetailCoachDto?.toTeamDetailCoach(),
            teamDetailCountryDto = teamDetailCountryDto?.toTeamDetailCountry(),
            teamDetailLeagueDto = teamDetailLeagueDto?.toTeamDetailLeague(),
            UEFARankingDto = UEFARankingDto?.toUEFARanking(),
            twitter = twitter,
            founded = founded
        )
    }
}