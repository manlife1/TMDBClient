package com.mr.tmdbclient.presentation.di.core

import com.mr.tmdbclient.data.api.TMDBService
import com.mr.tmdbclient.data.model.tvshow.TvShow
import com.mr.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.mr.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDatasourceImpl
import com.mr.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.mr.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDatasourceImpl
import com.mr.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.mr.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String){

    @Singleton
    @Provides
    fun providesMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDatasource{
        return MovieRemoteDatasourceImpl(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun providesArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource {
        return ArtistRemoteDatasourceImpl(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun providesTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDatasource {
        return TvShowRemoteDatasourceImpl(tmdbService,apiKey)
    }
}