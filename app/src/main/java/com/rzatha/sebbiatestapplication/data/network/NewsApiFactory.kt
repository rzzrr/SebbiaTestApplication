package com.rzatha.sebbiatestapplication.data.network

import com.google.gson.GsonBuilder
import com.rzatha.sebbiatestapplication.data.LocalDateTimeAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDateTime

object NewsApiFactory {
    private const val BASE_URL = "https://testtask.sebbia.com/"

    private val gson = GsonBuilder()
        .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeAdapter())
        .create()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(BASE_URL)
        .build()

    val apiService = retrofit.create(NewsApiService::class.java)
}