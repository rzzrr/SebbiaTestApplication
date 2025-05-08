package com.rzatha.sebbiatestapplication.data.network

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("list") val newsList: List<NewsDto>
)