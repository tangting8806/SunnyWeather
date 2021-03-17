package com.t.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

data class DailyResponse(
    @SerializedName("cityid")
    val cityId: String,
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
    @SerializedName("data")
    val data: List<Day>
){
    data class Day(
        @SerializedName("day")
        val day: String,
        @SerializedName("date")
        val date: String,
        @SerializedName("week")
        val week: String,
        @SerializedName("wea")
        val weather: String,
        @SerializedName("air")
        val air: String,
        @SerializedName("humidity")
        val humidity: String,
        @SerializedName("air_level")
        val airLevel: String,
        @SerializedName("air_tips")
        val airTips: String,
        @SerializedName("tem1")
        val tem1: String,
        @SerializedName("tem2")
        val tem2: String,
        @SerializedName("tem")
        val tem: String,
        @SerializedName("win")
        val win: List<String>,
        @SerializedName("win_speed")
        val windSpeed: String,
        @SerializedName("hours")
        val hours: List<HourWeather>,
        @SerializedName("index")
        val lifeIndex: List<LifeIndex>
    )

    data class HourWeather(
        @SerializedName("day")
        val day: String,
        @SerializedName("wea")
        val weather: String,
        @SerializedName("tem")
        val temperature: String,
        @SerializedName("win")
        val wind: String,
        @SerializedName("win_speed")
        val windSpeed: String
    )

    data class LifeIndex(
        @SerializedName("title")
        val title: String,
        @SerializedName("level")
        val level: String,
        @SerializedName("desc")
        val desc: String)
}

