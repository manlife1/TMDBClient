package com.mr.tmdbclient.domain.usecase

import com.mr.tmdbclient.data.model.artist.Artist
import com.mr.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}