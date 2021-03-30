package com.mr.tmdbclient.data.repository.artist.datasourceImpl

import com.mr.tmdbclient.data.db.ArtistDao
import com.mr.tmdbclient.data.model.artist.Artist
import com.mr.tmdbclient.data.model.movie.Movie
import com.mr.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDatasourceImpl(private val artistDao: ArtistDao):ArtistLocalDatasource {

    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}