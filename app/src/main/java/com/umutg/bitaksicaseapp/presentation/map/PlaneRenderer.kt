package com.umutg.bitaksicaseapp.presentation.map

import android.content.Context
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.DefaultClusterRenderer
import com.umutg.bitaksicaseapp.common.BitmapHelper
import com.umutg.bitaksicaseapp.domain.model.Plane

/**
 * A custom cluster renderer for Plane objects.
 */
class PlaneRenderer(
    private val context: Context,
    map: GoogleMap,
    clusterManager: ClusterManager<Plane>
) : DefaultClusterRenderer<Plane>(context, map, clusterManager) {

    /**
     * The icon to use for each cluster item
     */
    private val planeIcon: BitmapDescriptor by lazy {
        val color =
            ContextCompat.getColor(
                context,
                com.umutg.bitaksicaseapp.R.color.yellow
            )
        BitmapHelper.vectorToBitmap(
            context,
            com.umutg.bitaksicaseapp.R.drawable.ic_plane_36,
            color
        )
    }

    /**
     * Method called before the cluster item (the marker) is rendered.
     * This is where marker options should be set.
     */
    override fun onBeforeClusterItemRendered(
        plane: Plane,
        markerOptions: MarkerOptions
    ) {
        markerOptions
            .title(plane.icao24)
            .position(LatLng(plane.latitude, plane.longitude))
            .icon(planeIcon)
    }

    /**
     * Method called right after the cluster item (the marker) is rendered.
     * This is where properties for the Marker object should be set.
     */
    override fun onClusterItemRendered(clusterItem: Plane, marker: Marker) {
        marker.tag = clusterItem
    }
}