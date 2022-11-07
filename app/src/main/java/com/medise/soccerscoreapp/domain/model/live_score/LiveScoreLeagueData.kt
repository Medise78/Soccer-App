package com.medise.soccerscoreapp.domain.model.live_score

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class LiveScoreLeagueData(
    val active:@RawValue Boolean,
    val currentSeasonId:@RawValue Int,
    val id:@RawValue Int,
    val logoPath:@RawValue String,
    val name:@RawValue String,
):Parcelable
