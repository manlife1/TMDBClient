package com.mr.tmdbclient.data.repository.tvshow.datasourceImpl

import com.mr.tmdbclient.data.model.movie.Movie
import com.mr.tmdbclient.data.model.tvshow.TvShow
import com.mr.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource

class TvShowCacheDatasourceImpl :TvShowCacheDatasource{

    private var tvShowList=ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList= ArrayList(tvShows)
    }
}