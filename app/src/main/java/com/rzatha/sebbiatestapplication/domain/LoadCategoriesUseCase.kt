package com.rzatha.sebbiatestapplication.domain

class LoadCategoriesUseCase(private val repository: Repository) {

    suspend operator fun invoke()= repository.loadCategories()

}