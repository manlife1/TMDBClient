package com.mr.tmdbclient.domain.repository

import com.mr.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}
