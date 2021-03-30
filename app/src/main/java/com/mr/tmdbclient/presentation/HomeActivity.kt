package com.mr.tmdbclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mr.tmdbclient.R
import com.mr.tmdbclient.databinding.ActivityHomeBinding
import com.mr.tmdbclient.presentation.artist.ArtistActivity
import com.mr.tmdbclient.presentation.movie.MovieActivity
import com.mr.tmdbclient.presentation.tv.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_home)

        binding.movieButton.setOnClickListener {
            val intent= Intent(this,MovieActivity::class.java)
            startActivity(intent)
        }

        binding.artistsButton.setOnClickListener {
            val intent= Intent(this,ArtistActivity::class.java)
            startActivity(intent)
        }

        binding.tvButton.setOnClickListener {
            val intent= Intent(this,TvShowActivity::class.java)
            startActivity(intent)
        }
    }
}