package com.mr.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.mr.tmdbclient.data.db.ArtistDao
import com.mr.tmdbclient.data.db.MovieDao
import com.mr.tmdbclient.data.db.TMDBDatabase
import com.mr.tmdbclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun providesMovieDatabase(context: Context):TMDBDatabase{
        return Room.databaseBuilder(context,TMDBDatabase::class.java,"tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun providesMovieDao(tmdbDatabase: TMDBDatabase):MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun providesArtistDao(tmdbDatabase: TMDBDatabase):ArtistDao{
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun providesTvShowDao(tmdbDatabase: TMDBDatabase):TvShowDao{
        return tmdbDatabase.tvDao()
    }

}