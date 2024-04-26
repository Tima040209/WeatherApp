package com.example.weatherapp.Model.Entity

data class WeatherForecast(
    val cityName: String,
    val temperature: Double,
    val weatherDescription: String,
    val weatherIconUrl: String
)
