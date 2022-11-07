package com.medise.soccerscoreapp.domain.model.live_score

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Standings(
    val localteamPosition:@RawValue Int,
    val visitorteamPosition:@RawValue Int
):Parcelable
