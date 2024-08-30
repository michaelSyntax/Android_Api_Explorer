package com.example.android_base_starter.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.android_base_starter.databinding.ListRestautanteBinding
import com.example.android_base_starter.model.data.mockApi.Restaurant

class RestaurantAdapter(
    private val restaurants: List<Restaurant>
): RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {
    inner class RestaurantViewHolder(val vb: ListRestautanteBinding): ViewHolder(vb.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val vb = ListRestautanteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return RestaurantViewHolder(vb)
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = restaurants[position]

        holder.vb.ivRestaurant.load(restaurant.image)
        holder.vb.tvName.text = restaurant.name
        holder.vb.tvOpen.text = restaurant.isOpenNow()
        holder.vb.tvRating.text = restaurant.rating.toString()
        holder.vb.tvAddress.text = restaurant.latitude + ":" + restaurant.longitude
        holder.vb.tvReservation.text = restaurant.getReservation()
    }
}
