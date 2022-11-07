package com.medise.soccerscoreapp.domain.model.team_detail


data class TeamDetailData(
    val teamDetailCoachDto: TeamDetailCoach?,
    val teamDetailCountryDto: TeamDetailCountry?,
    val id: Int?,
    val teamDetailLeagueDto: TeamDetailLeague?,
    val logoPath: String?,
    val name: String?,
    val shortCode: String?,
    val twitter: String?,
    val UEFARankingDto: UefaRanking?,
    val founded:Int?
)
