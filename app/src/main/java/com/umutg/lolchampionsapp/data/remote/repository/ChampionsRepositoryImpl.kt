package com.umutg.lolchampionsapp.data.remote.repository

import com.umutg.lolchampionsapp.data.remote.ChampionsApi
import com.umutg.lolchampionsapp.data.remote.dto.champions.ChampionsDto
import com.umutg.lolchampionsapp.domain.repository.ChampionsRepository
import javax.inject.Inject

class ChampionsRepositoryImpl @Inject constructor(private val api: ChampionsApi) :
    ChampionsRepository {

    override suspend fun getChampions(): ChampionsDto {
        return api.getChampions()
    }
}