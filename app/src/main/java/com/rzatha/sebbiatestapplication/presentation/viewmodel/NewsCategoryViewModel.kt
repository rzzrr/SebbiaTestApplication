package com.rzatha.sebbiatestapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rzatha.sebbiatestapplication.data.repository.RepositoryImpl
import com.rzatha.sebbiatestapplication.domain.LoadCategoriesUseCase
import com.rzatha.sebbiatestapplication.domain.NewsCategory
import kotlinx.coroutines.launch

class NewsCategoryViewModel: ViewModel() {

    private val repository = RepositoryImpl()

    private val _newsCategoryList = MutableLiveData<List<NewsCategory>>()
    val newsCategoryList : LiveData<List<NewsCategory>>
            get() = _newsCategoryList

    init{
        viewModelScope.launch {
          _newsCategoryList.postValue(LoadCategoriesUseCase(repository).invoke())
        }
    }
}