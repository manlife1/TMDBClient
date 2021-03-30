package com.mr.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mr.tmdbclient.data.model.artist.Artist
import com.mr.tmdbclient.data.model.movie.Movie
import com.mr.tmdbclient.data.model.tvshow.TvShow

@Database(entities = [Movie::class,Artist::class, TvShow::class],version = 1,exportSchema = false)
abstract class TMDBDatabase:RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}