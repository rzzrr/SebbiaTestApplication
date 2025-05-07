package com.rzatha.sebbiatestapplication.domain

class LoadNewsListByCategoryUseCase(private val repository: Repository) {
    suspend operator fun invoke(categoryId: Int, page: Int) =
        repository.loadNewsListByCategory(categoryId, page)

}