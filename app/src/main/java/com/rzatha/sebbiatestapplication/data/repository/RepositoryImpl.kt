package com.rzatha.sebbiatestapplication.data.repository

import com.rzatha.sebbiatestapplication.data.Mapper
import com.rzatha.sebbiatestapplication.data.network.NewsApiFactory
import com.rzatha.sebbiatestapplication.domain.News
import com.rzatha.sebbiatestapplication.domain.NewsCategory
import com.rzatha.sebbiatestapplication.domain.Repository

class RepositoryImpl : Repository {

    private val apiService = NewsApiFactory.apiService
    private val mapper = Mapper()
    override suspend fun loadCategories(): List<NewsCategory> =
        mapper.mapNewsCategoryDtoListToNewsCategoryList(apiService.getCategories().categoryList)

    override suspend fun loadNewsListByCategory(categoryId: Int, page: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun loadNewsById(newsId: Int): News {
        TODO("Not yet implemented")
    }
}