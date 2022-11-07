package com.medise.soccerscoreapp.domain.model.live_score

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import java.io.Serializable

@Parcelize
data class LiveScoreData(
    val coachesDto:@RawValue Coaches?,
    val formationsDto:@RawValue Formations?,
    val id:@RawValue Int?,
    val leagueId:@RawValue Int?,
    val localteamId:@RawValue Int?,
    val scoresDto:@RawValue Scores?,
    val seasonId:@RawValue Int?,
    val standingsDto:@RawValue Standings?,
    val timeDto:@RawValue Time?,
    val visitorteamId:@RawValue Int?,
    val winnerTeamId:@RawValue Int?,
    val localTeam:@RawValue LocalTeamDetailResult?,
    val visitorTeam:@RawValue VisitorTeamDetailResult?,
    val league:@RawValue LiveScoreLeagueDetail?,
    val visitorCoach:@RawValue LiveScoreVisitorCoach?,
    val localCoach:@RawValue LiveScoreLocalCoach?,
    val goals:@RawValue Goals?
):Parcelable
