package com.mr.tmdbclient.data.model.tvshow

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class TvShowList(

	@field:SerializedName("results")
	val tvShows: List<TvShow?>? = null,

	)

@Entity(tableName = "popular_tvShows")
data class TvShow(

	@field:SerializedName("first_air_date")
	val firstAirDate: String? = null,

	@field:SerializedName("overview")
	val overview: String? = null,

	@field:SerializedName("poster_path")
	val posterPath: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@PrimaryKey
	@field:SerializedName("id")
	val id: Int? = null,

)
