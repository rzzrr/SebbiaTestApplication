package com.rzatha.sebbiatestapplication.domain

class LoadNewsPreviewUseCase(private val repository: Repository) {
    suspend operator fun invoke(categoryId: Int, page: Int) =
        repository.loadNewsPreview(categoryId, page)

}