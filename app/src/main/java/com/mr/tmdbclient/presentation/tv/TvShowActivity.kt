package com.mr.tmdbclient.presentation.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mr.tmdbclient.R
import com.mr.tmdbclient.databinding.ActivityTvShowBinding
import com.mr.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvViewModelFactory
    private lateinit var tvViewModel: TvViewModel
    private lateinit var binding: ActivityTvShowBinding
    private lateinit var adapter: TvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)

        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvViewModel = ViewModelProvider(this, factory)
            .get(TvViewModel::class.java)
        initRecyclerView()
        displayPopularTvShows()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initRecyclerView() {
        binding.tvRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvAdapter()
        binding.tvRecyclerView.adapter = adapter
    }

    private fun displayPopularTvShows() {
        binding.tvProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvViewModel.getTvShows()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvProgressBar.visibility = View.GONE
            } else {
                binding.tvProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun updateTvShows() {
        binding.tvProgressBar.visibility = View.VISIBLE
        val response = tvViewModel.updateTvShows()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvProgressBar.visibility = View.GONE
            } else {
                binding.tvProgressBar.visibility = View.GONE
            }
        })
    }
}