package com.umutg.lolchampionsapp.data.database.repository

import com.umutg.lolchampionsapp.data.database.dao.FavoriteChampionDao
import com.umutg.lolchampionsapp.data.database.entities.FavoriteChampionEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteChampionRepository @Inject constructor(
    private val favoriteChampionDao: FavoriteChampionDao,
) {

    fun getFavoriteChampions(): List<FavoriteChampionEntity> = favoriteChampionDao.getAll()

    fun saveFavoriteChampions(favoriteChampions: List<FavoriteChampionEntity>) {
        favoriteChampionDao.insertAll(favoriteChampions)
    }

    fun saveFavoriteChampion(favoriteChampion: FavoriteChampionEntity) {
        favoriteChampionDao.insert(favoriteChampion)
    }

    fun deleteFavoriteChampion(favoriteChampion: FavoriteChampionEntity) {
        favoriteChampionDao.delete(favoriteChampion)
    }

    fun findByName(championName: String): FavoriteChampionEntity? {
        return favoriteChampionDao.findByName(championName)
    }


}