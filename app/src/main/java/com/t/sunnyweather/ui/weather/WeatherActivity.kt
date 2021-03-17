package com.t.sunnyweather.ui.weather

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.t.sunnyweather.R
import com.t.sunnyweather.logic.model.WeatherModel
import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.android.synthetic.main.daily_weather_item.*

class WeatherActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewModel: WeatherModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        real_time_button.setOnClickListener(this)
        viewModel=WeatherModel()
    }

    override fun onClick(p0: View?) {
        when(p0){
            real_time_button->{
                Log.d("WeatherActivity","real_time_button")
                viewModel.weatherLiveData.observe(this, Observer {
                    //text.text = it.getOrNull().toString()
                    list_view.adapter=DailyWeatherAdapter(this,R.layout.daily_weather_item,it.getOrNull()!!.daily.data.toMutableList())
                })
            }
        }
    }


}