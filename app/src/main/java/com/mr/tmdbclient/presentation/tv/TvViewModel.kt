package com.mr.tmdbclient.presentation.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mr.tmdbclient.data.model.tvshow.TvShow
import com.mr.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.mr.tmdbclient.domain.usecase.UpdateTvShowsUseCase

class TvViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
):ViewModel() {
    
    fun getTvShows():LiveData<List<TvShow>?> = liveData { 
        val tvShowList:List<TvShow>? = getTvShowsUseCase.execute()
        
        emit(tvShowList)
    }
    
    fun updateTvShows() = liveData{ 
        val tvShowList:List<TvShow>? =updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
    
}