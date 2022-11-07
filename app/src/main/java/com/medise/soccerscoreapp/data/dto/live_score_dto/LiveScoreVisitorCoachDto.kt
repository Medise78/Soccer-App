package com.medise.soccerscoreapp.data.dto.live_score_dto

import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.LiveScoreLocalCoachData
import com.medise.soccerscoreapp.domain.model.live_score.LiveScoreVisitorCoach
import com.medise.soccerscoreapp.domain.model.live_score.LiveScoreVisitorCoachData

data class LiveScoreVisitorCoachDto(
    @SerializedName("data")
    val `data`: LiveScoreVisitorCoachDataDto
)

data class LiveScoreVisitorCoachDataDto(
    @SerializedName("birthcountry")
    val birthcountry: String,
    @SerializedName("birthdate")
    val birthdate: String?,
    @SerializedName("birthplace")
    val birthplace: String?,
    @SerializedName("coach_id")
    val coachId: Int,
    @SerializedName("common_name")
    val commonName: String,
    @SerializedName("country_id")
    val countryId: Int,
    @SerializedName("firstname")
    val firstname: String,
    @SerializedName("fullname")
    val fullname: String,
    @SerializedName("image_path")
    val imagePath: String?,
    @SerializedName("lastname")
    val lastname: String,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("team_id")
    val teamId: Int
)

fun LiveScoreVisitorCoachDataDto.toLocalScoreVisitorCoach(): LiveScoreVisitorCoachData{
    return LiveScoreVisitorCoachData(
        birthcountry, birthdate, birthplace, coachId, commonName, countryId, firstname, fullname, imagePath, lastname, nationality, teamId
    )
}

fun LiveScoreVisitorCoachDto.toLiveScoreVisitorCoach(): LiveScoreVisitorCoach {
    return LiveScoreVisitorCoach(
        data = data.toLocalScoreVisitorCoach()
    )
}
