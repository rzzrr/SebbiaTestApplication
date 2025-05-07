package com.rzatha.sebbiatestapplication.data.repository

import com.rzatha.sebbiatestapplication.domain.News
import com.rzatha.sebbiatestapplication.domain.NewsCategory
import com.rzatha.sebbiatestapplication.domain.Repository

class RepositoryImpl : Repository {
    override suspend fun loadCategories(): List<NewsCategory> {
        TODO("Not yet implemented")
    }

    override suspend fun loadNewsPreview(categoryId: Int, page: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun loadNewsById(newsId: Int): News {
        TODO("Not yet implemented")
    }
}