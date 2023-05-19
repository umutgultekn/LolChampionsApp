package com.umutg.bitaksicaseapp.presentation.map

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.ClusterManager
import com.umutg.bitaksicaseapp.common.BitmapHelper
import com.umutg.bitaksicaseapp.common.ErrorDialogListener
import com.umutg.bitaksicaseapp.common.Resource
import com.umutg.bitaksicaseapp.common.showErrorDialog
import com.umutg.bitaksicaseapp.databinding.FragmentMapBinding
import com.umutg.bitaksicaseapp.domain.model.Plane
import com.umutg.bitaksicaseapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MapFragment : BaseFragment<FragmentMapBinding>(FragmentMapBinding::inflate),
    View.OnClickListener,
    OnMapReadyCallback {

    private val viewModel: MapViewModel by viewModels()
    private lateinit var mapView: MapView
    private lateinit var map: GoogleMap


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapView = binding.mapView
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)


        viewModel.plane.observe(viewLifecycleOwner) { state ->

            when (state) {

                is Resource.Success -> {

                    addClusteredMarkers(state.data)
                }
                is Resource.Error -> {

                    showErrorDialog(requireContext(), state.message, object : ErrorDialogListener {
                        override fun onTryAgain() {
                            viewModel.loadPlanes()
                        }
                    })
                }
                is Resource.Loading -> {

//                    binding.shimmerLayout.startShimmer()

                }
            }


        }


    }


    override fun onClick(view: View?) {

        when (view?.id) {


        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val latLng = LatLng(41.0122, 28.976)
        val cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 10f)
        googleMap.moveCamera(cameraUpdate)

        viewModel.loadPlanes()

    }

//    private fun addMarkers(planes : List<Plane>?) {
//
//        planes?.forEach { plane ->
//            val marker = map.addMarker(
//                MarkerOptions()
//                    .title(plane.icao24)
//                    .position(LatLng(plane.latitude, plane.longitude))
//                    .icon(planeIcon)
//            )
//
//            // MarkerInfoWindowAdapter
//            marker.tag = plane
//        }
//    }

    private fun addClusteredMarkers(planes : List<Plane>?) {
        // Create the ClusterManager class and set the custom renderer.
        val clusterManager = ClusterManager<Plane>(requireContext(), map)
        clusterManager.renderer =
            PlaneRenderer(
                requireContext(),
                map,
                clusterManager
            )

        // Set custom info window adapter
        clusterManager.markerCollection.setInfoWindowAdapter(MarkerInfoWindowAdapter(requireContext()))

        // Add the planes to the ClusterManager.
        clusterManager.addItems(planes)
        clusterManager.cluster()

        // Set ClusterManager as the OnCameraIdleListener so that it
        // can re-cluster when zooming in and out.
        map.setOnCameraIdleListener {
            clusterManager.onCameraIdle()
        }
    }

    private val planeIcon: BitmapDescriptor by lazy {
        val color =
            ContextCompat.getColor(
                requireContext(),
                com.umutg.bitaksicaseapp.R.color.yellow
            )
        BitmapHelper.vectorToBitmap(
            requireContext(),
            com.umutg.bitaksicaseapp.R.drawable.ic_plane_36,
            color
        )
    }


    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }


}