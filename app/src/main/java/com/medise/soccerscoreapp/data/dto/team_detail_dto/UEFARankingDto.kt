package com.medise.soccerscoreapp.data.dto.team_detail_dto


import com.google.gson.annotations.SerializedName
import com.medise.soccerscoreapp.domain.model.team_detail.UefaRanking

data class UEFARankingDto(
    @SerializedName("data")
    val `data`: UEFARankingDataDto?
){
    fun toUEFARanking():UefaRanking{
        return UefaRanking(
            data?.toUEFARankingData()
        )
    }
}