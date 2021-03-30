package com.mr.tmdbclient.domain.repository

import com.mr.tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}