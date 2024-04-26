package com.example.weatherapp.cities_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentCitiesBinding
import com.example.weatherapp.weather_fragment.WeatherFragment

class CitiesFragment : Fragment() {

    private lateinit var binding: FragmentCitiesBinding

    private val cities = listOf("Shymkent", "Astana", "Almaty", "Lisbon", "London")
    private val adapter by lazy {
        CitiesAdapter() {
            parentFragmentManager.commit {
                replace(R.id.mainContainer, WeatherFragment::class.java, bundleOf(WeatherFragment.CITY_KEY to it))
                addToBackStack("weather")
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCitiesBinding.inflate(layoutInflater)
        binding.recyclerView.adapter = adapter
        adapter.submitList(cities)
        return binding.root
    }
}