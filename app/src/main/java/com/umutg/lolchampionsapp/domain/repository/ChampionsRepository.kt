package com.umutg.lolchampionsapp.domain.repository

import com.umutg.lolchampionsapp.data.remote.dto.champion.ChampionDto
import com.umutg.lolchampionsapp.data.remote.dto.champions.ChampionsDto

interface ChampionsRepository {

    suspend fun getChampions(): ChampionsDto

    suspend fun getChampionById(name: String): ChampionDto
}