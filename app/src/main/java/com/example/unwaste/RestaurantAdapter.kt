package com.example.unwaste

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter to display restaurants.
 * Code taken from
 * https://medium.com/android-news/consuming-rest-api-using-retrofit-library-in-android-ed47aef01ecb
 * and https://www.geeksforgeeks.org/android-recyclerview/#
 */

class RestaurantAdapter(
    private val restaurants: List<Restaurant>,
    private val rowLayout: Int,
    private val context: Context
) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    inner class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val restaurantsLayout: RelativeLayout = itemView.findViewById(R.id.restaurant_card)
        val location: TextView = itemView.findViewById(R.id.location)
        val open_hours: TextView = itemView.findViewById(R.id.open_hours)
        val available_for_pickup: TextView = itemView.findViewById(R.id.available_for_pickup)
        val cuisine_type: TextView = itemView.findViewById(R.id.cuisine_type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(rowLayout, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.location.text = restaurants[position].location
        holder.open_hours.text = restaurants[position].open_hours
        holder.available_for_pickup.text = restaurants[position].available_for_pickup
        holder.cuisine_type.text = restaurants[position].cuisine_type
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }
}
