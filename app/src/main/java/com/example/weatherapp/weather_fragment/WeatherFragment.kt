package com.example.weatherapp.weather_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.Model.API.WeatherApiClient
import com.example.weatherapp.Model.Entity.weather_model.WeatherResponse
import com.example.weatherapp.R
import com.example.weatherapp.cities_fragment.CitiesFragment
import com.example.weatherapp.databinding.FragmentWeatherBinding

class WeatherFragment: Fragment() {

    private lateinit var binding: FragmentWeatherBinding
    private val factory by lazy { WeatherViewModelFactory(WeatherApiClient.create()) }
    private val viewModel by viewModels<WeatherViewModel> { factory }
    private val city by lazy { arguments?.getString(CITY_KEY).orEmpty() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWeatherBinding.inflate(layoutInflater)
        viewModel.onEvent(WeatherEvents.FetchCityWeather(city))
        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }
        viewModel.weather.observe(viewLifecycleOwner) {
            handleResult(it)
        }
        binding.homeText.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.mainContainer, CitiesFragment())
                addToBackStack(null)
            }
        }
        return binding.root
    }



    private fun handleResult(response: WeatherResponse) = with(binding){
        cityTextView.text = response.name
        temperatureTextView.text = "${(response.main.temp - 273).toInt()}°"
        weatherDescTextView.text = response.weather.firstOrNull()?.description.orEmpty()
    }

    companion object{
        const val CITY_KEY = "city"
    }
}