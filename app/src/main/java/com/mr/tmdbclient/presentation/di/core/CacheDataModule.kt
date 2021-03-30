package com.mr.tmdbclient.presentation.di.core

import com.mr.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import com.mr.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDatasourceImpl
import com.mr.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.mr.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDatasourceImpl
import com.mr.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.mr.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowCacheDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun providesMovieCacheDatasource():MovieCacheDatasource{
        return MovieCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun providesArtistCacheDatasource(): ArtistCacheDatasource {
        return ArtistCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun providesTvShowCacheDatasource(): TvShowCacheDatasource {
        return TvShowCacheDatasourceImpl()
    }
}