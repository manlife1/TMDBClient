package com.mr.tmdbclient.data.repository.artist.datasource

import com.mr.tmdbclient.data.model.artist.Artist
import com.mr.tmdbclient.data.model.movie.Movie

interface ArtistCacheDatasource {

    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(artists:List<Artist>)

}