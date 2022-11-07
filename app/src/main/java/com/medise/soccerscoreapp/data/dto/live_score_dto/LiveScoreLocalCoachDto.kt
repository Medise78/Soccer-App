package com.medise.soccerscoreapp.data.dto.live_score_dto

import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.live_score.LiveScoreLocalCoach
import com.medise.soccerscoreapp.domain.model.live_score.LiveScoreLocalCoachData

data class LiveScoreLocalCoachDto(
    @SerializedName("data")
    val `data`: LiveScoreLocalCoachDataDto
){
    fun LiveScoreLocalCoach():LiveScoreLocalCoach{
        return LiveScoreLocalCoach(
            data.LiveScoreLocalCoachData()
        )
    }
}

data class LiveScoreLocalCoachDataDto(
    @SerializedName("birthcountry")
    val birthcountry: String,
    @SerializedName("birthdate")
    val birthdate: String,
    @SerializedName("birthplace")
    val birthplace: String,
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
    val imagePath: String,
    @SerializedName("lastname")
    val lastname: String,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("team_id")
    val teamId: Int
){
    fun LiveScoreLocalCoachData():LiveScoreLocalCoachData{
        return LiveScoreLocalCoachData(
            birthcountry, birthdate, birthplace, coachId, commonName, countryId, firstname, fullname, imagePath, lastname, nationality, teamId
        )
    }
}
