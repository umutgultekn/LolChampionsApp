package com.umutg.bitaksicaseapp.domain.repository

import com.umutg.bitaksicaseapp.data.remote.dto.PlaneStatesDto

interface PlaneRepository {

    suspend fun getPlanes(): PlaneStatesDto

}