package com.example.unwaste

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.Places

class MapsFragment : Fragment() {

    private val TAG = MapsFragment::class.java.simpleName

    private lateinit var mMap: GoogleMap

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val iowaCity = LatLng(41.66113, -91.53017)
        mMap.addMarker(MarkerOptions().position(iowaCity).title("Click on me to get places and routes!!!"))
        mMap.moveCamera(CameraUpdateFactory.zoomTo(15F))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(iowaCity))

        for (marker in placeMarkers) {
            //mMap.addMarker(MarkerOptions().position(customMarker).title(marker.title))
            val customMarker = LatLng(marker.latitude, marker.longitude)
            val locName = marker.title
            val contactNum = marker.contact
            val marker = mMap.addMarker(
                MarkerOptions()
                    .position(customMarker)
                    .title(locName)
                    .snippet("${contactNum}")
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        // Initialize the SDK
        Places.initialize(context, "@string/maps_api_key")

        // Create a new PlacesClient instance
        val placesClient = Places.createClient(context)
    }
}