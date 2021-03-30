package com.mr.tmdbclient.data.repository.artist.datasource

import com.mr.tmdbclient.data.model.artist.Artist
import com.mr.tmdbclient.data.model.movie.Movie

interface ArtistLocalDatasource {

    suspend fun getArtistsFromDB():List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAll()
}