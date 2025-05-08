package com.rzatha.sebbiatestapplication.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApiService {

    @GET("/v1/news/categories")
    suspend fun loadCategories(): Response<CategoriesResponse>

    @GET("/v1/news/categories/{id}/news")
    suspend fun loadNewsByCategory(
        @Path(PARAM_ID) categoryId: Int,
        @Query(PARAM_PAGE) page: Int
    ): Response<NewsResponse>

    @GET("/v1/news/details")
    suspend fun loadNewsById(
        @Query(PARAM_ID) id: Int
    ) : Response<NewsDetailResponse>

    companion object {
        private const val PARAM_ID = "id"
        private const val PARAM_PAGE = "page"
    }
}