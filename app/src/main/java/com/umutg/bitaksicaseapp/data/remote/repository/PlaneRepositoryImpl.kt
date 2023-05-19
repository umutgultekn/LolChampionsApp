package com.umutg.bitaksicaseapp.data.remote.repository

import com.umutg.bitaksicaseapp.data.remote.OpenSkyApi
import com.umutg.bitaksicaseapp.data.remote.dto.PlaneStatesDto
import com.umutg.bitaksicaseapp.domain.repository.PlaneRepository

import javax.inject.Inject

class PlaneRepositoryImpl @Inject constructor(private val api: OpenSkyApi) :
    PlaneRepository {

    override suspend fun getPlanes(): PlaneStatesDto {
        return api.getPlanes()
    }

}