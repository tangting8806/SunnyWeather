package com.t.sunnyweather.logic.network

import android.util.Log
import androidx.lifecycle.liveData
import com.t.sunnyweather.logic.model.Weather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import java.lang.RuntimeException


object Repository {
    fun refreshWeather() = liveData(Dispatchers.IO) {
        val result = try {
            coroutineScope {
                Log.d("Repository","Repository")
                val deferredRealTime = async {
                    SunnyWeatherNetWork.getRealTimeWeather()
                }
                val deferredDaily = async {
                    SunnyWeatherNetWork.getDailyWeather()
                }

                val deferredRealTimeResponse = deferredRealTime.await()
                val deferredDailyResponse = deferredDaily.await()
                val weather = Weather(
                    deferredRealTimeResponse,
                    deferredDailyResponse
                )
                Result.success(weather)

//                if (deferredRealTimeResponse.status == "OK" && deferredDailyResponse.status == "OK") {
//                    val weather = Weather(
//                        deferredRealTimeResponse.result.realTime,
//                        deferredDailyResponse.result.daily
//                    )
//                    Result.success(weather)
//                } else {
//                    Result.failure(RuntimeException("real time weather is ${deferredRealTimeResponse.result.realTime} ,daily weather is ${deferredDailyResponse.result.daily}"))
//                }
            }
        } catch (e: Exception) {
            Result.failure<Weather>(e)
        }
        emit(result)
    }
}