package com.mr.tmdbclient.presentation.di.artist

import com.mr.tmdbclient.domain.usecase.GetArtistUseCase
import com.mr.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.mr.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun providesArtistViewModelFactory(getArtistUseCase: GetArtistUseCase,
                                       updateArtistsUseCase: UpdateArtistsUseCase):ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistUseCase,updateArtistsUseCase)
    }
}