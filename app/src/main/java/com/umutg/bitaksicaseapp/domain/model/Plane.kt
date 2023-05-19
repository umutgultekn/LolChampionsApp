package com.umutg.bitaksicaseapp.domain.model

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

data class Plane(
    val icao24: String,
    val callsign: String,
    val originCountry: String,
    val timePosition: Double,
    val longitude: Double,
    val latitude: Double,
    val baroAltitude: Double

) : ClusterItem {
    override fun getPosition(): LatLng =
        LatLng(latitude, longitude)

    override fun getTitle(): String =
        icao24

    override fun getSnippet(): String =
        originCountry
}