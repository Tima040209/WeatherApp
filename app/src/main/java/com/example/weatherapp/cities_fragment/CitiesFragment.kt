package com.example.weatherapp.cities_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.weatherapp.Model.SharedPreferencesHelper
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentCitiesBinding
import com.example.weatherapp.weather_fragment.WeatherFragment
import java.util.ArrayList
import java.util.Locale

class CitiesFragment : Fragment() {

    private lateinit var binding: FragmentCitiesBinding
    private lateinit var sharedPreferences: SharedPreferencesHelper;

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
        binding.searchEditText.addTextChangedListener {
          val searchQuery = it.toString()
          if(searchQuery.isEmpty()){
            adapter.submitList(cities)
          } else {
              binding.searchButton.setOnClickListener {
                val list = cities.filter {
                  it.lowercase(Locale.ROOT).contains(searchQuery)
            }
            adapter.submitList(ArrayList(list))
          }
        }
      }
      return binding.root
    }
}
