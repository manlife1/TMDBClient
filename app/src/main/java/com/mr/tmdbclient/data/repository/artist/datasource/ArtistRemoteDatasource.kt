package com.mr.tmdbclient.data.repository.artist.datasource

import com.mr.tmdbclient.data.model.artist.ArtistList
import com.mr.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDatasource {

    suspend fun getArtists(): Response<ArtistList>
}