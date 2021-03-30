package com.mr.tmdbclient.data.repository.tvshow.datasourceImpl

import com.mr.tmdbclient.data.api.TMDBService
import com.mr.tmdbclient.data.model.movie.MovieList
import com.mr.tmdbclient.data.model.tvshow.TvShowList
import com.mr.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDatasourceImpl(private val tmdbService: TMDBService,
private val apiKey:String): TvShowRemoteDatasource {

    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}