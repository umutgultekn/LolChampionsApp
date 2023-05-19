package com.umutg.bitaksicaseapp.presentation.map

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.umutg.bitaksicaseapp.R
import com.umutg.bitaksicaseapp.common.Utils
import com.umutg.bitaksicaseapp.domain.model.Plane

class MarkerInfoWindowAdapter(
    private val context: Context
) : GoogleMap.InfoWindowAdapter {

    override fun getInfoContents(marker: Marker?): View? {
        // 1. Get tag
        val plane = marker?.tag as? Plane ?: return null

        // 2. Inflate view and set title, address, and rating
        val view = LayoutInflater.from(context).inflate(
            R.layout.plane_info_contents, null
        )

        view.findViewById<TextView>(
            R.id.text_view_callsign
        ).text = plane.callsign

        view.findViewById<TextView>(
            R.id.text_view_icao24
        ).text = "Icao24: ${plane.icao24}"

        view.findViewById<TextView>(
            R.id.text_view_country
        ).text = "Country: ${plane.originCountry}"

        view.findViewById<TextView>(
            R.id.text_view_latitude
        ).text = "Lat: ${plane.latitude}"

        view.findViewById<TextView>(
            R.id.text_view_longitude
        ).text = "Long: ${plane.longitude}"

        view.findViewById<TextView>(
            R.id.text_view_time
        ).text = "Time: ${Utils.convertTimestampToDate(plane.timePosition)}"

        return view
    }

    override fun getInfoWindow(marker: Marker?): View? {
        // Return null to indicate that the
        // default window (white bubble) should be used
        return null
    }
}