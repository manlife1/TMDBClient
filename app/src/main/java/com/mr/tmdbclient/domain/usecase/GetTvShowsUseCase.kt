package com.mr.tmdbclient.domain.usecase

import com.mr.tmdbclient.data.model.tvshow.TvShow
import com.mr.tmdbclient.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute():List<TvShow>? =tvShowRepository.getTvShows()
}