package com.example.unwaste

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter to display food items.
 * Code taken from
 * https://medium.com/android-news/consuming-rest-api-using-retrofit-library-in-android-ed47aef01ecb
 * and https://www.geeksforgeeks.org/android-recyclerview/#
 */

class FoodAdapter(
    private val foods: List<Food>,
    private val rowLayout: Int
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val food_name: TextView = itemView.findViewById(R.id.food_name)
        val food_category: TextView = itemView.findViewById(R.id.food_category)
        val food_quantity: TextView = itemView.findViewById(R.id.food_quantity)
        val package_size: TextView = itemView.findViewById(R.id.package_size)
        val expiration_date: TextView = itemView.findViewById(R.id.expiration_date)
        val food_description: TextView = itemView.findViewById(R.id.food_description)
        val dietary_restriction: TextView = itemView.findViewById(R.id.dietary_restriction)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(rowLayout, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val currentFood = foods[position]
        Log.d("Food Adapter", "Food at position $position: $currentFood")
        holder.food_name.text = foods[position].food_name
        holder.food_category.text = foods[position].food_category
        holder.food_quantity.text = foods[position].food_quantity
        holder.package_size.text = foods[position].package_size
        holder.expiration_date.text = foods[position].expiration_date
        holder.food_description.text = foods[position].food_description
        holder.dietary_restriction.text = foods[position].dietary_restriction
    }

    override fun getItemCount(): Int {
        return foods.size
    }
}