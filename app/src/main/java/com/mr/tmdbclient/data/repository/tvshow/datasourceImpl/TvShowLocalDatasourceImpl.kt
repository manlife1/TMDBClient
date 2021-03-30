package com.mr.tmdbclient.data.repository.tvshow.datasourceImpl

import com.mr.tmdbclient.data.db.TvShowDao
import com.mr.tmdbclient.data.model.movie.Movie
import com.mr.tmdbclient.data.model.tvshow.TvShow
import com.mr.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDatasourceImpl(private val tvShowDao: TvShowDao) :TvShowLocalDatasource{
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}