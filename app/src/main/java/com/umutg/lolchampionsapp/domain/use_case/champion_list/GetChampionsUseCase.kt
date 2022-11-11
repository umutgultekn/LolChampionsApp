package com.umutg.lolchampionsapp.domain.use_case.champion_list

import com.umutg.lolchampionsapp.data.remote.dto.champions.toChampionList
import com.umutg.lolchampionsapp.domain.model.Champions
import com.umutg.lolchampionsapp.domain.repository.ChampionsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetChampionsUseCase @Inject constructor(private val repository: ChampionsRepository) {

    suspend fun getAllChampions(): List<Champions> {
        return repository.getChampions().data.map { it.value.toChampionList() }
    }

}