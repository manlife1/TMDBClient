package com.mr.tmdbclient.data.repository.movie.datasourceImpl

import com.mr.tmdbclient.data.api.TMDBService
import com.mr.tmdbclient.data.model.movie.MovieList
import com.mr.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(private val tmdbService:TMDBService,
                                private val apiKey:String): MovieRemoteDatasource {

    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}