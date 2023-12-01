package com.example.unwaste

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unwaste.ui.theme.UnWasteDark
import com.example.unwaste.ui.theme.UnWasteLight
import com.example.unwaste.ui.theme.UnwasteTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class InventoryActivity : ComponentActivity() {

    private val TAG = InventoryActivity::class.java.simpleName

    //Need to change this to the IP address of the computer running the server when testing
    val BASE_URL = "http://192.168.1.230:8080/inventoryManager/"
    private lateinit var retrofit: Retrofit
    private lateinit var recyclerView: RecyclerView

    // insert your API KEY here
    private val API_KEY = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inventory_activity)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        connectAndGetApiData()

        /**setContent {
        UnwasteTheme {
        Surface {
        AddEntryButton()
        }
        }
        }*/
    }


    // This method creates an instance of Retrofit and sets the base URL
    private fun connectAndGetApiData() {
        retrofit = RetrofitClient.getClient(BASE_URL)
        val apiService: ApiService = retrofit.create(ApiService::class.java)
        val call: Call<List<Restaurant>> = apiService.restaurants

        call.enqueue(object : Callback<List<Restaurant>> {
            override fun onResponse(
                call: Call<List<Restaurant>>,
                response: Response<List<Restaurant>>
            ) {
                val restaurants: List<Restaurant>? = response.body()?.toList()
                restaurants?.let {
                    recyclerView.adapter =
                        RestaurantAdapter(it, R.layout.restaurant_card)
                    Log.d(TAG, "Number of restaurants received: ${restaurants.size}")
                }
            }

            override fun onFailure(call: Call<List<Restaurant>>, t: Throwable) {
                Log.e(TAG, "Failed to fetch restaurants: ${t.message}")
            }
        })
    }

    // @Preview function is use to see preview
// for our composable function in preview section.
    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        UnwasteTheme {
            // we are passing our composable
            // function to display its preview.
            AddEntryButton()
        }
    }

    @Composable
    fun AddEntryButton() {
        Box {
            Button(
                onClick = {/*open add entry modal*/ },
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
                colors = ButtonDefaults.buttonColors(
                    containerColor = UnWasteLight,
                    contentColor = UnWasteDark,
                    disabledContentColor = UnWasteLight,
                    disabledContainerColor = UnWasteDark
                ),
                modifier = Modifier.align(Alignment.BottomEnd)
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Localized description",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Add Entry")
            }
        }
    }
}