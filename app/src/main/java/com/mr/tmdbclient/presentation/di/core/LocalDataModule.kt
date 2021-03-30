package com.mr.tmdbclient.presentation.di.core

import com.mr.tmdbclient.data.api.TMDBService
import com.mr.tmdbclient.data.db.ArtistDao
import com.mr.tmdbclient.data.db.MovieDao
import com.mr.tmdbclient.data.db.TvShowDao
import com.mr.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import com.mr.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.mr.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDatasourceImpl
import com.mr.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDatasourceImpl
import com.mr.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.mr.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.mr.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDatasourceImpl
import com.mr.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDatasourceImpl
import com.mr.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.mr.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.mr.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDatasourceImpl
import com.mr.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providesMovieLocalDataSource(movieDao: MovieDao): MovieLocalDatasource {
        return MovieLocalDatasourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun providesArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDatasource {
        return ArtistLocalDatasourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun providesTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDatasource {
        return TvShowLocalDatasourceImpl(tvShowDao)
    }
}