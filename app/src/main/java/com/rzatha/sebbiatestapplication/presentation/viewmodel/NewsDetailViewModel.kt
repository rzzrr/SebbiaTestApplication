package com.rzatha.sebbiatestapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rzatha.sebbiatestapplication.data.repository.RepositoryImpl
import com.rzatha.sebbiatestapplication.domain.LoadNewsByIdUseCase
import com.rzatha.sebbiatestapplication.domain.News
import kotlinx.coroutines.launch

class NewsDetailViewModel: ViewModel() {
    private val repository = RepositoryImpl()

    private val _news = MutableLiveData<News>()
    val news: LiveData<News>
        get() = _news

    fun loadNewsDetail(newsId: Int){
        viewModelScope.launch {
            val news = LoadNewsByIdUseCase(repository).invoke(newsId)
            _news.postValue(news)
        }
    }
}