package com.example.weatherapp.Model.Entity.weather_model

data class System(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)