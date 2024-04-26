package com.example.weatherapp.weather_fragment

sealed interface WeatherEvents {
    data class FetchCityWeather(val cityName: String): WeatherEvents
    data class RefreshCityWeather(val cityName: String): WeatherEvents
}