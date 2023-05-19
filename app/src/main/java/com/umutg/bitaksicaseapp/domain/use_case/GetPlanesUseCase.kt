package com.umutg.bitaksicaseapp.domain.use_case

import com.umutg.bitaksicaseapp.data.remote.dto.toPlaneList
import com.umutg.bitaksicaseapp.domain.model.Plane
import com.umutg.bitaksicaseapp.domain.repository.PlaneRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetPlanesUseCase @Inject constructor(private val repository: PlaneRepository) {

    suspend fun getPlanes(latitude: Float, longitude: Float): List<Plane> {
        return repository.getPlanes().toPlaneList()
    }

}