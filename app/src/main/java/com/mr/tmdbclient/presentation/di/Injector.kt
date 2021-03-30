package com.mr.tmdbclient.presentation.di

import com.mr.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.mr.tmdbclient.presentation.di.movie.MovieSubComponent
import com.mr.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}