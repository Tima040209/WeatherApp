package com.example.weatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.commit
import com.example.weatherapp.Model.SharedPreferencesHelper
import com.example.weatherapp.cities_fragment.CitiesAdapter
import com.example.weatherapp.databinding.FragmentCitiesBinding
import com.example.weatherapp.databinding.FragmentFavBinding
import com.example.weatherapp.weather_fragment.WeatherFragment
import java.util.ArrayList
import java.util.Locale


class FavFragment : Fragment() {
  private lateinit var binding: FragmentFavBinding
  private lateinit var sharedPreferences: SharedPreferencesHelper;
  private val cities = listOf(sharedPreferences.getFavoriteCities(requireContext()))
  private val adapter by lazy {
    CitiesAdapter() {
      parentFragmentManager.commit {
        replace(R.id.mainContainer, WeatherFragment::class.java, bundleOf(WeatherFragment.CITY_KEY to it))
        addToBackStack("weather")
      }
    }
  }
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = FragmentFavBinding.inflate(layoutInflater)
    binding.favRecyclerView.adapter = adapter
//    adapter.submitList(cities)
    return binding.root
  }
}
