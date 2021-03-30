package com.mr.tmdbclient.presentation.di.tvshow

import com.mr.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.mr.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.mr.tmdbclient.presentation.tv.TvViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun providesTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvViewModelFactory {
        return TvViewModelFactory(getTvShowsUseCase,updateTvShowsUseCase)
    }
}