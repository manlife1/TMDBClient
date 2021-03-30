package com.mr.tmdbclient.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mr.tmdbclient.R
import com.mr.tmdbclient.data.model.movie.Movie
import com.mr.tmdbclient.databinding.ListItemBinding

class MovieAdapter():RecyclerView.Adapter<MyViewHolder>() {
    private val movieList=ArrayList<Movie>()

    fun setList(movies:List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val binding:ListItemBinding =DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binds(movieList[position],position+1)
    }

    override fun getItemCount(): Int =movieList.size

}

class MyViewHolder(val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root) {

    fun binds(movie:Movie,position: Int){
        (position.toString()+". "+movie.title).also { binding.titleTextView.text = it }
        binding.descriptionTextView.text=movie.overview
        val posterUrl="https://image.tmdb.org/t/p/w500"+movie.posterPath
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }
}