package com.mr.tmdbclient.data.repository.tvshow

import android.util.Log
import com.mr.tmdbclient.data.model.tvshow.TvShow
import com.mr.tmdbclient.data.model.tvshow.TvShowList
import com.mr.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.mr.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.mr.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.mr.tmdbclient.domain.repository.TvShowRepository
import retrofit2.Response

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource:TvShowRemoteDatasource,
    private val tvShowCacheDatasource: TvShowCacheDatasource,
    private val tvShowLocalDatasource: TvShowLocalDatasource) :TvShowRepository{

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows:List<TvShow> =getTvShowsFromAPI()
        tvShowLocalDatasource.clearAll()
        tvShowLocalDatasource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDatasource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try{
            val response:Response<TvShowList> = tvShowRemoteDatasource.getTvShows()
            val body: TvShowList?=response.body()

            if(body!=null) {
                tvShowList = body.tvShows as List<TvShow>
            }
        } catch(e:Exception){
            Log.i("MyTag", e.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try{
            tvShowList=tvShowLocalDatasource.getTvShowsFromDB()
        } catch(e:Exception){
            Log.i("MyTag", e.message.toString())
        }

        if(tvShowList.isNotEmpty()){
            return tvShowList
        } else{
            tvShowList=getTvShowsFromAPI()
            tvShowLocalDatasource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try{
            tvShowList=tvShowCacheDatasource.getTvShowsFromCache()
        } catch(e:Exception){
            Log.i("MyTag", e.message.toString())
        }

        if(tvShowList.isNotEmpty()){
            return tvShowList
        } else{
            tvShowList=getTvShowsFromDB()
            tvShowCacheDatasource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }



}