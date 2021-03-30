package com.mr.tmdbclient.data.repository.tvshow.datasource

import com.mr.tmdbclient.data.model.movie.MovieList
import com.mr.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {

    suspend fun getTvShows(): Response<TvShowList>
}