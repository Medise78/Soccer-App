package com.medise.soccerscoreapp.domain.model.live_score

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class LocalTeamDetailResult(
    val data:@RawValue LocalTeamDetail
):Parcelable
