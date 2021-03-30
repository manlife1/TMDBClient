package com.mr.tmdbclient.data.repository.movie.datasource

import com.mr.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {

    suspend fun getMovies():Response<MovieList>
}