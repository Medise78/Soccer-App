package com.medise.soccerscoreapp.domain.model.live_score

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Coaches(
    val localteamCoachId:@RawValue Int,
    val visitorteamCoachId:@RawValue Int
):Parcelable

@Parcelize
data class LiveScoreLocalCoach(
    val `data`:@RawValue LiveScoreLocalCoachData
):Parcelable

@Parcelize
data class LiveScoreLocalCoachData(
    val birthcountry:@RawValue String,
    val birthdate:@RawValue String?,
    val birthplace:@RawValue String?,
    val coachId:@RawValue Int,
    val commonName:@RawValue String,
    val countryId:@RawValue Int,
    val firstname:@RawValue String,
    val fullname:@RawValue String,
    val imagePath:@RawValue String?,
    val lastname:@RawValue String,
    val nationality:@RawValue String,
    val teamId:@RawValue Int
):Parcelable

@Parcelize
data class LiveScoreVisitorCoach(
    val `data`:@RawValue LiveScoreVisitorCoachData
):Parcelable

@Parcelize
data class LiveScoreVisitorCoachData(
    val birthcountry:@RawValue String,
    val birthdate:@RawValue String?,
    val birthplace:@RawValue String?,
    val coachId:@RawValue Int,
    val commonName:@RawValue String,
    val countryId:@RawValue Int,
    val firstname:@RawValue String,
    val fullname:@RawValue String,
    val imagePath:@RawValue String?,
    val lastname:@RawValue String,
    val nationality:@RawValue String,
    val teamId:@RawValue Int
):Parcelable
