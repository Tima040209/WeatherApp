package com.example.weatherapp.Model.Entity.weather_model

import com.google.gson.annotations.SerializedName

data class Wind(
        @SerializedName("deg")
        val degree: Double,
        val speed: Double
)