package com.mr.tmdbclient.presentation.di.core

import com.mr.tmdbclient.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl:String) {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideTMDBService(retrofit:Retrofit): TMDBService{
        return retrofit.create(TMDBService::class.java)
    }

}