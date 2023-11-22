package com.example.unwaste;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

/** ViewHolder for the Restaurant class.
 *  Code taken from https://www.geeksforgeeks.org/android-recyclerview/# */

public class RestaurantViewHolder extends RecyclerView.ViewHolder {
    TextView location;
    TextView open_hours;

    TextView available_for_pickup;

    TextView cuisine_type;

    View view;

    RestaurantViewHolder(View itemView)
    {
        super(itemView);
        location
                = (TextView)itemView
                .findViewById(R.id.location);
        open_hours
                = (TextView)itemView
                .findViewById(R.id.open_hours);
        available_for_pickup
                = (TextView)itemView
                .findViewById(R.id.available_for_pickup);
        cuisine_type
                = (TextView)itemView
                .findViewById(R.id.cuisine_type);
        view  = itemView;
    }
}
