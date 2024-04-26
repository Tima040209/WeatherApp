package com.example.weatherapp.Model.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherApiClient {

    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    fun create(): WeatherApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(WeatherApiService::class.java)
    }
}
