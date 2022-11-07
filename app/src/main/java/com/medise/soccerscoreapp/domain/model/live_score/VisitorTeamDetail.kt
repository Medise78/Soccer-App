package com.medise.soccerscoreapp.domain.model.live_score

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class VisitorTeamDetail(
    val id:@RawValue Int,
    val logoPath:@RawValue String,
    val name:@RawValue String,
    val shortCode:@RawValue String?=null,
):Parcelable
