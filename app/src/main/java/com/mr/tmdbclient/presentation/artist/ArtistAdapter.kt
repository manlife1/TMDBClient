package com.mr.tmdbclient.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mr.tmdbclient.R
import com.mr.tmdbclient.data.model.artist.Artist
import com.mr.tmdbclient.databinding.ListItemBinding

class ArtistAdapter(): RecyclerView.Adapter<MyViewHolder>() {
    private val artistList=ArrayList<Artist>()

    fun setList(artists:List<Artist>){
        artistList.clear()
        artistList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binds(artistList[position],position+1)
    }

    override fun getItemCount(): Int =artistList.size

}

class MyViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun binds(artist: Artist, position: Int){
        (position.toString()+". "+artist.name).also { binding.titleTextView.text = it }
        binding.descriptionTextView.text=artist.popularity.toString()
        val posterUrl="https://image.tmdb.org/t/p/w500"+artist.profilePath
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }
}