package com.t.sunnyweather.logic.network

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object SunnyWeatherNetWork {
    private final val weatherService = ServiceCreator.create<WeatherService>()

    suspend fun getDailyWeather() = weatherService.getDailyWeather().await()

    suspend fun getRealTimeWeather() = weatherService.getRealTimeWeather().await()

    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(
                object : Callback<T> {
                    override fun onResponse(call: Call<T>, response: Response<T>) {
                        val body = response.body()
                        Log.d("SunnyWeatherNetWork","${body}")
                        if (body != null) continuation.resume(body)
                        else continuation.resumeWithException(RuntimeException("response body is null"))
                    }

                    override fun onFailure(call: Call<T>, t: Throwable) {
                        continuation.resumeWithException(t)
                    }
                }

            )
        }
    }
}