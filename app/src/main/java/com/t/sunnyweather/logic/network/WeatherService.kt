package com.t.sunnyweather.logic.network

import com.t.sunnyweather.logic.model.DailyResponse
import com.t.sunnyweather.logic.model.RealTimeResponse
import retrofit2.Call
import retrofit2.http.GET

interface WeatherService {
    @GET("/api?version=v6&appid=24318355&appsecret=aVDiJl7o")
    fun getRealTimeWeather(): Call<RealTimeResponse>

    @GET("/api?version=v1&appid=24318355&appsecret=aVDiJl7o")
    fun getDailyWeather(): Call<DailyResponse>

}