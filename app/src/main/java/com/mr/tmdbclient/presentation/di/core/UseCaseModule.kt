package com.mr.tmdbclient.presentation.di.core

import com.mr.tmdbclient.domain.repository.ArtistRepository
import com.mr.tmdbclient.domain.repository.MovieRepository
import com.mr.tmdbclient.domain.repository.TvShowRepository
import com.mr.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule {

    @Provides
    fun providesGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun providesUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun providesGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase {
        return GetArtistUseCase(artistRepository)
    }

    @Provides
    fun providesUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }

    @Provides
    fun providesGetTvShowUseCase(tvShowRepository: TvShowRepository):GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun providesUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }
}