package com.medise.soccerscoreapp.domain.model.live_score

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Formations(
    val localteamFormation:@RawValue String? = null,
    val visitorteamFormation:@RawValue String? = null
):Parcelable
