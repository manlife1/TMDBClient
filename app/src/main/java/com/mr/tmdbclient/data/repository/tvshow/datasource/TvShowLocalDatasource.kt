package com.mr.tmdbclient.data.repository.tvshow.datasource

import com.mr.tmdbclient.data.model.movie.Movie
import com.mr.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDatasource {

    suspend fun getTvShowsFromDB():List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}