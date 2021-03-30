package com.mr.tmdbclient.data.repository.movie.datasource

import com.mr.tmdbclient.data.model.movie.Movie

interface MovieCacheDatasource {

    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
}