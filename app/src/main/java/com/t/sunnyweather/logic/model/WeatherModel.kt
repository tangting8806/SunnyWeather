package com.t.sunnyweather.logic.model

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.t.sunnyweather.logic.network.Repository

class WeatherModel:ViewModel() {
    val weatherLiveData=Repository.refreshWeather()
}