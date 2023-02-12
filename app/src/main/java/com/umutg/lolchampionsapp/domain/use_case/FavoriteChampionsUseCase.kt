package com.umutg.lolchampionsapp.domain.use_case

import com.umutg.lolchampionsapp.data.database.entities.FavoriteChampionEntity
import com.umutg.lolchampionsapp.data.database.repository.FavoriteChampionRepository

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteChampionsUseCase @Inject constructor(private val repository: FavoriteChampionRepository) {

    suspend fun findByName(id: String): FavoriteChampionEntity? {
        return repository.findByName(id)
    }

    suspend fun getFavoriteChampions(): List<FavoriteChampionEntity> {
        return repository.getFavoriteChampions()
    }

    suspend fun saveFavoriteChampion(favoriteChampion: FavoriteChampionEntity) {
        repository.saveFavoriteChampion(favoriteChampion)
    }

    suspend fun deleteFavoriteChampion(favoriteChampion: FavoriteChampionEntity) {
        repository.deleteFavoriteChampion(favoriteChampion)
    }

}