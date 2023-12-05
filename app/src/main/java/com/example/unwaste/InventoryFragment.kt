package com.example.unwaste

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Fragment for displaying and managing the restaurant's inventory.
 *
 * Code for Retrofit and API integrations adapted from
 * https://medium.com/android-news/consuming-rest-api-using-retrofit-library-in-android-ed47aef01ecb
 * and https://www.geeksforgeeks.org/android-recyclerview/#
 */
class InventoryFragment : Fragment() {

    private val TAG = InventoryFragment::class.java.simpleName

    //Need to change this to the IP address of the computer running the server when testing
    val BASE_URL = "http://192.168.1.230:8080/inventoryManager/"
    private lateinit var retrofit: Retrofit
    private lateinit var recyclerView: RecyclerView

    // insert your API KEY here
    private val API_KEY = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView called")
        val myView = inflater.inflate(R.layout.fragment_inventory, container, false)
        recyclerView = myView.findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        connectAndGetApiData()
        myView.findViewById<FloatingActionButton>(R.id.add_entry)?.setOnClickListener {
            // To dim the inventory:
            val dimOverlay: View = myView.findViewById(R.id.dim_overlay)
            dimOverlay.visibility = View.VISIBLE
            Log.d(TAG, "Dim overlay visibility: ${dimOverlay.visibility}")

            // To show the add entry dialog:
            val supportFragmentManager = requireActivity().supportFragmentManager
            val dialogFragment = AddEntryDialogFragment.newInstance(1)

            // Remove dim when dialog is dismissed:
            dialogFragment.setOnDismissListener(object : OnDismissListener {
                override fun onDismiss() {
                    dimOverlay.visibility = View.GONE
                }
            })

            // Show dialog:
            dialogFragment.show(supportFragmentManager, "dialog")
        }

        // Inflate the layout for this fragment
        return myView
    }

    // This method creates an instance of Retrofit and sets the base URL
    private fun connectAndGetApiData() {
        retrofit = RetrofitClient.getClient(BASE_URL)
        val apiService: ApiService = retrofit.create(ApiService::class.java)
        val call: Call<List<Food>> = apiService.foods

        call.enqueue(object : Callback<List<Food>> {
            override fun onResponse(
                call: Call<List<Food>>,
                response: Response<List<Food>>
            ) {
                val foods: List<Food>? = response.body()?.toList()
                foods?.let {
                    recyclerView.adapter =
                        FoodAdapter(it, R.layout.food_card)
                    Log.d(TAG, "Number of foods received: ${foods.size}")   
                }
            }

            override fun onFailure(call: Call<List<Food>>, t: Throwable) {
                Log.e(TAG, "Failed to fetch foods: ${t.message}")
            }
        })
    }
}