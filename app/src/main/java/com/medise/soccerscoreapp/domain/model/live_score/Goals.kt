package com.medise.soccerscoreapp.domain.model.live_score

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


@Parcelize
data class Goals(
    val `data`:@RawValue List<GoalsData>
):Parcelable

@Parcelize
data class GoalsData(
    val extraMinute:@RawValue Int?,
    val id:@RawValue Long?,
    val minute:@RawValue Int?,
    val playerAssistName:@RawValue String?,
    val playerName:@RawValue String?,
    val result:@RawValue String?,
    val type:@RawValue String?
):Parcelable
