package com.rzatha.sebbiatestapplication.data.network

import retrofit2.http.GET

interface NewsApiService {

    @GET("/v1/news/categories")
    suspend fun getCategories(): CategoriesResponse


}