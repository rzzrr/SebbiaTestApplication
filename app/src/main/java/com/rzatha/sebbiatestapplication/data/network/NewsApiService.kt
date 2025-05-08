package com.rzatha.sebbiatestapplication.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApiService {

    @GET("/v1/news/categories")
    suspend fun getCategories(): Response<CategoriesResponse>

    @GET("/v1/news/categories/{id}/news")
    suspend fun getNewsByCategory(
        @Path(PATH_PARAM_ID) categoryId: Int,
        @Query(QUERY_PARAM_PAGE) page: Int
    ): Response<NewsResponse>

    companion object {
        private const val PATH_PARAM_ID = "id"
        private const val QUERY_PARAM_PAGE = "page"
    }
}