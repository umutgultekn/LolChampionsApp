package com.umutg.lolchampionsapp.data.database.dao

import androidx.room.*
import com.umutg.lolchampionsapp.data.database.entities.FavoriteChampionEntity

@Dao
interface FavoriteChampionDao {

    @Query("SELECT * FROM champion order by id asc")
    fun getAll(): List<FavoriteChampionEntity>

    @Query("SELECT * FROM champion WHERE name = :championName LIMIT 1")
    fun findByName(championName: String): FavoriteChampionEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(FavoriteChampionEntity: FavoriteChampionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(favoriteChampions: Collection<FavoriteChampionEntity>)

    @Delete
    fun delete(favoriteChampionEntity: FavoriteChampionEntity)
}