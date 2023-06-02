package com.example.umc_study09.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BoxOfficeResult(
    @SerializedName("boxofficeType")
    @Expose
    val boxofficeType: String?,
    @SerializedName("showRange")
    @Expose
    val showRange: String?,
    @SerializedName("dailyBoxOfficeList")
    @Expose
    val dailyBoxOfficeList: List<DailyBoxOffice>?
)