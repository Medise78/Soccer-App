package com.medise.soccerscoreapp.domain.model.live_score

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Scores(
    val etScore:@RawValue String? = null,
    val ftScore:@RawValue String? = null,
    val htScore:@RawValue String? = null,
    val localteamScore:@RawValue Int,
    val visitorteamScore:@RawValue Int
):Parcelable
