package com.example.weatherapp.Model.Entity.weather_model

import com.google.gson.annotations.SerializedName

data class Coordinates(
        @SerializedName("lat")
        val latitude: Double,
        @SerializedName("lon")
        val longitude: Double
)