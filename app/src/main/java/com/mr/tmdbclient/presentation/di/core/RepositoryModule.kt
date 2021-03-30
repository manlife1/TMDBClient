package com.mr.tmdbclient.presentation.di.core

import com.mr.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.mr.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import com.mr.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import com.mr.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.mr.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.mr.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.mr.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.mr.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.mr.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.mr.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.mr.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.mr.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.mr.tmdbclient.domain.repository.ArtistRepository
import com.mr.tmdbclient.domain.repository.MovieRepository
import com.mr.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRespository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource:MovieLocalDatasource,
        movieCacheDatasource: MovieCacheDatasource

    ):MovieRepository{

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieCacheDatasource,
            movieLocalDatasource,
        )

    }

    @Singleton
    @Provides
    fun provideArtistRespository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistCacheDatasource: ArtistCacheDatasource,
        artistLocalDatasource: ArtistLocalDatasource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistCacheDatasource,
            artistLocalDatasource,
        )

    }

    @Singleton
    @Provides
    fun provideTvShowRespository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowCacheDatasource: TvShowCacheDatasource,
        tvShowLocalDatasource: TvShowLocalDatasource

    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowCacheDatasource,
            tvShowLocalDatasource,
        )

    }
}