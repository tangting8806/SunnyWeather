package com.t.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

data class RealTimeResponse
    (
    @SerializedName("cityid")
    val cityId: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("week")
    val week: String,
    @SerializedName("update_time")
    val updateTime: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("cityEn")
    val cityEn: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("countryEn")
    val countryEn: String,
    @SerializedName("wea")
    val weather: String,
    @SerializedName("tem")
    val tem: String,
    @SerializedName("tem1")
    val tem1: String,
    @SerializedName("tem2")
    val tem2: String,
    @SerializedName("win")
    val wind: String,
    @SerializedName("win_speed")
    val windSpeed: String,
    @SerializedName("win_meter")
    val windMeter: String,
    @SerializedName("humidity")
    val humidity: String,
    @SerializedName("visibility")
    val visibility: String,
    @SerializedName("air")
    val air: String,
    @SerializedName("air_level")
    val airLevel: String,
    @SerializedName("air_tips")
    val airTips: String
)