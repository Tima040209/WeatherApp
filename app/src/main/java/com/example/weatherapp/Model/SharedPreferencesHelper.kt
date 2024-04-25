package com.example.weatherapp.Model

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("WeatherAppPrefs", Context.MODE_PRIVATE)

}
