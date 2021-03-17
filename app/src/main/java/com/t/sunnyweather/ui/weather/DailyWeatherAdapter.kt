package com.t.sunnyweather.ui.weather

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.t.sunnyweather.R
import com.t.sunnyweather.logic.model.DailyResponse
import com.t.sunnyweather.logic.model.Weather
import kotlinx.android.synthetic.main.daily_weather_item.view.*

class DailyWeatherAdapter(context: Context, resource: Int, objects: MutableList<DailyResponse.Day>) :
    ArrayAdapter<DailyResponse.Day>(context, resource, objects) {
    private var resourceId: Int? = null

    init {
        resourceId = resource
    }

    @SuppressLint("SetTextI18n", "ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val dailyWeather = getItem(position)!!
        val view = LayoutInflater.from(context).inflate(resourceId!!, parent, false)
        val timeTextView = view.findViewById<TextView>(R.id.time)
        val temperatureTextView = view.findViewById<TextView>(R.id.temperature)
        val weatherTextView = view.findViewById<TextView>(R.id.weather)
        val humidityTextView = view.findViewById<TextView>(R.id.humidity)
        timeTextView.text = dailyWeather.date + dailyWeather.day + dailyWeather.week
        temperatureTextView.text = dailyWeather.tem
        weatherTextView.text = dailyWeather.weather
        humidityTextView.text = dailyWeather.humidity
        return view
    }


}