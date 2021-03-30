package com.mr.tmdbclient.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mr.tmdbclient.data.model.movie.Movie
import com.mr.tmdbclient.domain.usecase.GetMoviesUseCase
import com.mr.tmdbclient.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
):ViewModel() {

    fun getMovies(): LiveData<List<Movie>?> = liveData{
        val movieList:List<Movie>? = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData{
        val movieList:List<Movie>? = updateMoviesUseCase.execute()
        emit(movieList)
    }

}