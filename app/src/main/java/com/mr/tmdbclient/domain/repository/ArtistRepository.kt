package com.mr.tmdbclient.domain.repository

import com.mr.tmdbclient.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}