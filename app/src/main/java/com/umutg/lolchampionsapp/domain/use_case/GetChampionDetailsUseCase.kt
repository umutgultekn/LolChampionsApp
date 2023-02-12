package com.umutg.lolchampionsapp.domain.use_case

import com.umutg.lolchampionsapp.data.remote.dto.champion.toChampion
import com.umutg.lolchampionsapp.domain.model.Champion
import com.umutg.lolchampionsapp.domain.repository.ChampionsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetChampionDetailsUseCase @Inject constructor(private val repository: ChampionsRepository) {

    suspend fun getChampionById(name: String): List<Champion> {
        return repository.getChampionById(name).data.map { it.value.toChampion() }
    }

}