package com.medise.soccerscoreapp.data.dto.team_detail_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.team_detail.UefaRankingData

data class UEFARankingDataDto(
    @SerializedName("position")
    val position: Int?,
){
    fun toUEFARankingData():UefaRankingData{
        return UefaRankingData(
            position
        )
    }
}