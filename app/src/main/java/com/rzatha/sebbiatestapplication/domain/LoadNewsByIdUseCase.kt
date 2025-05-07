package com.rzatha.sebbiatestapplication.domain

class LoadNewsByIdUseCase(private val repository: Repository) {

    suspend operator fun invoke(newsId: Int) = repository.loadNewsById(newsId)

}