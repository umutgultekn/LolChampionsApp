package com.umutg.lolchampionsapp.data.remote

import com.umutg.lolchampionsapp.data.remote.dto.champion.ChampionDto
import com.umutg.lolchampionsapp.data.remote.dto.champions.ChampionsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ChampionsApi {

    @GET("/cdn/12.21.1/data/en_US/champion.json")
    suspend fun getChampions(): ChampionsDto

    @GET("/cdn/12.21.1/data/en_US/champion/{id}.json")
    suspend fun getChampionById(@Path("id") id: String): ChampionDto
}