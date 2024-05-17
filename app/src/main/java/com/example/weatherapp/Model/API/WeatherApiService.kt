package com.example.weatherapp.Model.API

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.Model.Entity.weather_model.WeatherResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface WeatherApiService {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String = "b16c935423febc2c1e80889552e6e6b0"
    ): WeatherResponse
}