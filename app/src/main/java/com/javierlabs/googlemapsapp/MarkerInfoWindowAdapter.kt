package com.javierlabs.googlemapsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.javierlabs.googlemapsapp.place.Place

class MarkerInfoWindowAdapter(private val context: Context) : GoogleMap.InfoWindowAdapter {

    override fun getInfoContents(marker: Marker): View? {
        //get the tag
        val place = marker?.tag as? Place ?: return null

        //inflate view and set title, address, and rating
        val view = LayoutInflater.from(context).inflate(R.layout.marker_info_contents, null)

        view.findViewById<TextView>(R.id.text_view_title).text = place.name //name
        view.findViewById<TextView>(R.id.text_view_address).text = place.address
        view.findViewById<TextView>(R.id.text_view_rating).text = "Rating: %.2f".format(place.rating)

        return view
    }

    override fun getInfoWindow(marker: Marker): View? {
        //return null to show the default window should be used
        return null
    }

}
