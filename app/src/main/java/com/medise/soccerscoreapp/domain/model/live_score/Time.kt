package com.medise.soccerscoreapp.domain.model.live_score

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Time(
    val addedTime:@RawValue Int,
    val extraMinute:@RawValue Int,
    val minute:@RawValue Int,
    val second:@RawValue Int,
    val startingAtDto: StartingAt,
):Parcelable
