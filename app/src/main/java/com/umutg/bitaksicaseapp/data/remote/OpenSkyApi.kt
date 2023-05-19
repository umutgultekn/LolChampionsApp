package com.umutg.bitaksicaseapp.data.remote

import com.umutg.bitaksicaseapp.data.remote.dto.PlaneStatesDto
import retrofit2.http.GET

interface OpenSkyApi {

    @GET("/api//states/all?lomin=27.3445316488&lamin=40.226013967&lomax=30.7411966586&lamax=41.6004635693")
    suspend fun getPlanes(): PlaneStatesDto

}