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

    private var _currentPage = MutableLiveData<Int>(0)
    val currentPage: LiveData<Int>
        get() = _currentPage

    fun loadNewsByCategory(categoryId: Int) {
        viewModelScope.launch {
            val listNews =
                LoadNewsListByCategoryUseCase(repository).invoke(
                    categoryId,
                    _currentPage.value ?: 0
                )
            _newsList.postValue(listNews)
        }
    }

    fun increasePage(categoryId: Int) {
        _currentPage.value = (_currentPage.value ?: 0) + 1
        loadNewsByCategory(categoryId)
    }


    fun decreasePage(categoryId: Int) {
        val current = _currentPage.value ?: 0
        if (current > 0) {
            _currentPage.value = current - 1
            loadNewsByCategory(categoryId)
        }
    }

}