package com.mr.tmdbclient.data.model.artist

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class ArtistList(

	@field:SerializedName("results")
	val artists: List<Artist?>? = null,

)

@Entity(tableName = "popular_artists")
data class Artist(

	@field:SerializedName("popularity")
	val popularity: Double? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("profile_path")
	val profilePath: String? = null,

	@PrimaryKey
	@field:SerializedName("id")
	val id: Int? = null,
)
