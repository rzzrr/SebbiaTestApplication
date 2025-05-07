package com.rzatha.sebbiatestapplication.domain


interface Repository {
    suspend fun loadCategories() : List<NewsCategory>
    suspend fun loadNewsListByCategory(categoryId: Int, page: Int) : List<News>
    suspend fun loadNewsById(newsId: Int): News
}