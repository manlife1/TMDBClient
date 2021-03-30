package com.mr.tmdbclient.data.repository.movie

import android.util.Log
import com.mr.tmdbclient.data.model.movie.Movie
import com.mr.tmdbclient.data.model.movie.MovieList
import com.mr.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.mr.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.mr.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.mr.tmdbclient.domain.repository.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieCacheDatasource: MovieCacheDatasource,
    private val movieLocalDatasource: MovieLocalDatasource
):MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies:List<Movie> =getMoviesFromAPI()
        movieLocalDatasource.clearAll()
        movieLocalDatasource.saveMoviesToDB(newListOfMovies)
        movieCacheDatasource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI():List<Movie>{
        lateinit var movieList:List<Movie>
        try{
            val response:Response<MovieList> = movieRemoteDatasource.getMovies()
            val body:MovieList?=response.body()

            if(body!=null) {
                movieList = body.movies as List<Movie>
            }
        } catch(e:Exception){
            Log.i("MyTag", e.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB():List<Movie>{
        lateinit var movieList:List<Movie>
        try{
            movieList=movieLocalDatasource.getMoviesFromDB()
        } catch(e:Exception){
            Log.i("MyTag", e.message.toString())
        }

        if(movieList.isNotEmpty()){
            return movieList
        } else{
            movieList=getMoviesFromAPI()
            movieLocalDatasource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList:List<Movie>
        try{
            movieList=movieCacheDatasource.getMoviesFromCache()
        } catch(e:Exception){
            Log.i("MyTag", e.message.toString())
        }

        if(movieList.isNotEmpty()){
            return movieList
        } else{
            movieList=getMoviesFromDB()
            movieCacheDatasource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}