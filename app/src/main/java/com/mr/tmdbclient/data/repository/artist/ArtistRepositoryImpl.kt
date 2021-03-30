package com.mr.tmdbclient.data.repository.artist

import android.util.Log
import com.mr.tmdbclient.data.model.artist.Artist
import com.mr.tmdbclient.data.model.artist.ArtistList
import com.mr.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import com.mr.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import com.mr.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.mr.tmdbclient.domain.repository.ArtistRepository
import retrofit2.Response

class ArtistRepositoryImpl (
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistCacheDatasource: ArtistCacheDatasource,
    private val artistLocalDatasource: ArtistLocalDatasource
): ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists:List<Artist> =getArtistsFromAPI()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistsToDB(newListOfArtists)
        artistCacheDatasource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI():List<Artist>{
        lateinit var artistList:List<Artist>
        try{
            val response: Response<ArtistList> = artistRemoteDatasource.getArtists()
            val body: ArtistList?=response.body()

            if(body!=null) {
                artistList = body.artists as List<Artist>
            }
        } catch(e:Exception){
            Log.i("MyTag", e.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB():List<Artist>{
        lateinit var artistList:List<Artist>
        try{
            artistList=artistLocalDatasource.getArtistsFromDB()
        } catch(e:Exception){
            Log.i("MyTag", e.message.toString())
        }

        if(artistList.isNotEmpty()){
            return artistList
        } else{
            artistList=getArtistsFromAPI()
            artistLocalDatasource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache():List<Artist>{
        lateinit var artistList:List<Artist>
        try{
            artistList=artistCacheDatasource.getArtistsFromCache()
        } catch(e:Exception){
            Log.i("MyTag", e.message.toString())
        }

        if(artistList.isNotEmpty()){
            return artistList
        } else{
            artistList=getArtistsFromDB()
            artistCacheDatasource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}