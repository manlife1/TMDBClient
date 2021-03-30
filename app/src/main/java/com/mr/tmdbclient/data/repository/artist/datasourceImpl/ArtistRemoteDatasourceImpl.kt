package com.mr.tmdbclient.data.repository.artist.datasourceImpl

import com.mr.tmdbclient.data.api.TMDBService
import com.mr.tmdbclient.data.model.artist.ArtistList
import com.mr.tmdbclient.data.model.movie.MovieList
import com.mr.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDatasourceImpl(private val tmdbService: TMDBService,
private val apiKey:String): ArtistRemoteDatasource
{

    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}