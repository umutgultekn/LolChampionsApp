package com.umutg.bitaksicaseapp.di


import com.umutg.bitaksicaseapp.common.Constants
import com.umutg.bitaksicaseapp.data.remote.OpenSkyApi
import com.umutg.bitaksicaseapp.data.remote.repository.PlaneRepositoryImpl

import com.umutg.bitaksicaseapp.domain.repository.PlaneRepository
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
    fun provideOpenSkyApi(): OpenSkyApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenSkyApi::class.java)
    }

    @Provides
    @Singleton
    fun providePlaneRepository(api: OpenSkyApi): PlaneRepository {
        return PlaneRepositoryImpl(api)
    }


}