package com.example.weatherapp.weather_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.Model.API.WeatherApiService
import com.example.weatherapp.Model.Entity.weather_model.WeatherResponse
import java.lang.Exception
import kotlinx.coroutines.launch

class WeatherViewModel(private val service: WeatherApiService): ViewModel() {

    private val _weatherData = MutableLiveData<WeatherResponse>()
    private val _isLoading = MutableLiveData<Boolean>()
    val weather: LiveData<WeatherResponse> get() = _weatherData
    val isLoading: LiveData<Boolean> get() = _isLoading


    fun onEvent(event: WeatherEvents){
        when(event){
            is WeatherEvents.FetchCityWeather -> loadCityInfo(event.cityName)
            is WeatherEvents.RefreshCityWeather -> loadCityInfo(event.cityName)
        }
    }

    private fun loadCityInfo(cityName: String){
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _weatherData.value = service.getCurrentWeather(cityName)
            } catch (e: Exception){
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}

class WeatherViewModelFactory(private val service: WeatherApiService): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WeatherViewModel(service) as T
    }
}