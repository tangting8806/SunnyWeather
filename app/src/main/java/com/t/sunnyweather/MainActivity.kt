package com.t.sunnyweather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.t.sunnyweather.ui.weather.WeatherActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        weather_button.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            weather_button -> {
                val intent = Intent(this, WeatherActivity::class.java)
                startActivity(intent)
            }
        }
    }
    
}