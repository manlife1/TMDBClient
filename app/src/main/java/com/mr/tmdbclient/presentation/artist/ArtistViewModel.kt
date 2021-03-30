package com.mr.tmdbclient.presentation.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mr.tmdbclient.data.model.artist.Artist
import com.mr.tmdbclient.domain.usecase.GetArtistUseCase
import com.mr.tmdbclient.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
):ViewModel() {

    fun getArtists(): LiveData<List<Artist>?> = liveData{
        val artistList:List<Artist>? = getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData{
        val artistList:List<Artist>? = updateArtistsUseCase.execute()
        emit(artistList)
    }
}