package com.example.weatherapp.Model.Entity.weather_model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
        val base: String,
        val clouds: Clouds,
        val cod: Int,
        @SerializedName("coords")
        val coordinates: Coordinates,
        val dt: Int,
        val id: Int,
        val main: Main,
        val name: String,
        val sys: System,
        val timezone: Int,
        val visibility: Int,
        val weather: List<Weather>,
        val wind: Wind
)