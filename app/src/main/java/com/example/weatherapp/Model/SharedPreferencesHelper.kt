package com.example.weatherapp.Model

import android.content.Context
import android.content.SharedPreferences

object SharedPreferencesHelper {

    private const val PREFS_NAME = "WeatherAppPrefs"
    private const val KEY_FAVORITE_CITIES = "favoriteCities"

    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveFavoriteCities(context: Context, cities: Set<String>) {
        val prefs = getSharedPreferences(context)
        val editor = prefs.edit()
        editor.putStringSet(KEY_FAVORITE_CITIES, cities)
        editor.apply()
    }

    fun getFavoriteCities(context: Context): Set<String>? {
        val prefs = getSharedPreferences(context)
        return prefs.getStringSet(KEY_FAVORITE_CITIES, null)
    }
}

