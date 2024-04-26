package com.example.weatherapp.cities_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.ItemCityBinding

class CitiesAdapter(private val onClick: (String) -> Unit) : ListAdapter<String, CitiesAdapter.ViewHolder>(DiffUtilCallback) {

    inner class ViewHolder(val binding: ItemCityBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCityBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.root.text = currentList[position]
        holder.binding.root.setOnClickListener {
            onClick.invoke(currentList[position])
        }
    }

    private object DiffUtilCallback : DiffUtil.ItemCallback<String>() {

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem

        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
    }
}
