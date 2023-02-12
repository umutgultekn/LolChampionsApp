package com.umutg.lolchampionsapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.umutg.lolchampionsapp.data.database.dao.FavoriteChampionDao
import com.umutg.lolchampionsapp.data.database.entities.FavoriteChampionEntity

@Database(entities = [FavoriteChampionEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun championDao(): FavoriteChampionDao

    companion object {

        private const val DB_NAME = "champion-db"

        // For Singleton instantiation
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java, DB_NAME
            ).build()
        }
    }

}