package com.rzatha.sebbiatestapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rzatha.sebbiatestapplication.data.repository.RepositoryImpl
import com.rzatha.sebbiatestapplication.domain.LoadNewsListByCategoryUseCase
import com.rzatha.sebbiatestapplication.domain.News
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val repository = RepositoryImpl()

    private val _newsList = MutableLiveData<List<News>>()
    val newsList: LiveData<List<News>>
        get() = _newsList

    private var currentPage = 0

    fun loadNewsByCategory(categoryId: Int) {
        viewModelScope.launch {
            val listNews = LoadNewsListByCategoryUseCase(repository).invoke(categoryId, currentPage++)
            _newsList.postValue(listNews)
        }
    }

}