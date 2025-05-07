package com.rzatha.sebbiatestapplication.domain


interface Repository {
    suspend fun loadCategories()
    suspend fun loadNewsPreview(categoryId: Int, page: Int)
    suspend fun loadNewsById(newsId: Int): News
}