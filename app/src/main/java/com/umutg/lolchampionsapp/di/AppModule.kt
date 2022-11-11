package com.umutg.lolchampionsapp.di

import com.umutg.lolchampionsapp.common.Constants
import com.umutg.lolchampionsapp.data.remote.ChampionsApi
import com.umutg.lolchampionsapp.data.remote.repository.ChampionsRepositoryImpl
import com.umutg.lolchampionsapp.domain.repository.ChampionsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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

}