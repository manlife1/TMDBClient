package com.mr.tmdbclient.domain.usecase

import com.mr.tmdbclient.data.model.movie.Movie
import com.mr.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>?=movieRepository.getMovies()


}