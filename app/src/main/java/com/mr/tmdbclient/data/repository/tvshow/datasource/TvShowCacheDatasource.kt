package com.mr.tmdbclient.data.repository.tvshow.datasource

import com.mr.tmdbclient.data.model.movie.Movie
import com.mr.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDatasource {

    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowsToCache(tvShows:List<TvShow>)
}