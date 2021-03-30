package com.mr.tmdbclient.presentation.di.movie

import com.mr.tmdbclient.domain.usecase.GetMoviesUseCase
import com.mr.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.mr.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun providesMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase,updateMoviesUseCase)
    }
}