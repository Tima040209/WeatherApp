package com.example.weatherapp.Model.Entity.weather_model

import com.google.gson.annotations.SerializedName

data class Main(
        @SerializedName("feelsLike")
        val feelsLike: Double,
        val humidity: Int,
        val pressure: Int,
        val temp: Double,
        @SerializedName("temp_max")
        val temperatureMax: Double,
        @SerializedName("temp_min")
        val temperatureMin: Double
)