package com.mr.tmdbclient.presentation.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mr.tmdbclient.R
import com.mr.tmdbclient.data.model.tvshow.TvShow
import com.mr.tmdbclient.databinding.ListItemBinding

class TvAdapter: RecyclerView.Adapter<MyViewHolder>() {
    private val tvShowList=ArrayList<TvShow>()

    fun setList(tvShows:List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(tvShows)
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
        holder.binds(tvShowList[position],position+1)
    }

    override fun getItemCount(): Int =tvShowList.size

}

class MyViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun binds(tvShow: TvShow,position: Int){
        (position.toString()+". "+tvShow.name).also { binding.titleTextView.text = it }
        binding.descriptionTextView.text=tvShow.overview
        val posterUrl="https://image.tmdb.org/t/p/w500"+tvShow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }
}