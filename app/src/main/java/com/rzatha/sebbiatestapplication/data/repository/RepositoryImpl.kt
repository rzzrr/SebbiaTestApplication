package com.rzatha.sebbiatestapplication.data.repository

import com.rzatha.sebbiatestapplication.data.Mapper
import com.rzatha.sebbiatestapplication.data.network.NewsApiFactory
import com.rzatha.sebbiatestapplication.domain.News
import com.rzatha.sebbiatestapplication.domain.NewsCategory
import com.rzatha.sebbiatestapplication.domain.Repository
import retrofit2.HttpException

class RepositoryImpl : Repository {

    private val apiService = NewsApiFactory.apiService
    private val mapper = Mapper()

    override suspend fun loadCategories(): List<NewsCategory> {
        val response = apiService.getCategories()
        if (response.isSuccessful) {
            val categoriesResponse = response.body()
            return mapper.mapNewsCategoryDtoListToNewsCategoryList(categoriesResponse?.categoryList ?: emptyList())
        } else {
            throw HttpException(response)
        }
    }

    override suspend fun loadNewsListByCategory(
        categoryId: Int,
        page: Int
    ): List<News> {
        val response = apiService.getNewsByCategory(categoryId, page)
        if (response.isSuccessful) {
            val newsResponse = response.body()
            return mapper.mapNewsDtoListToNewsList(newsResponse?.newsList ?: emptyList())
        } else {
            throw HttpException(response)
        }
    }

    override suspend fun loadNewsById(newsId: Int): News {
        TODO("Not yet implemented")
    }
}