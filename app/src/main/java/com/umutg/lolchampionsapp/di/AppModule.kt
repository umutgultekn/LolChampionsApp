package com.umutg.lolchampionsapp.di

import android.content.Context
import com.umutg.lolchampionsapp.common.Constants
import com.umutg.lolchampionsapp.data.database.AppDatabase
import com.umutg.lolchampionsapp.data.database.dao.FavoriteChampionDao
import com.umutg.lolchampionsapp.data.remote.ChampionsApi
import com.umutg.lolchampionsapp.data.remote.repository.ChampionsRepositoryImpl
import com.umutg.lolchampionsapp.domain.repository.ChampionsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideChampionsApi(): ChampionsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChampionsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideChampionsRepository(api: ChampionsApi): ChampionsRepository {
        return ChampionsRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }


    @Provides
    fun provideChampionDao(appDatabase: AppDatabase): FavoriteChampionDao {
        return appDatabase.championDao()
    }


}