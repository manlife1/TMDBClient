package com.mr.tmdbclient.data.model.movie

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class MovieList(

	@field:SerializedName("results")
	val movies: List<Movie?>? = null,

	)

@Entity(tableName = "popular_movies")
data class Movie(

	@field:SerializedName("overview")
	val overview: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("poster_path")
	val posterPath: String? = null,

	@field:SerializedName("release_date")
	val releaseDate: String? = null,

	@PrimaryKey
	@field:SerializedName("id")
	val id: Int? = null,
)
