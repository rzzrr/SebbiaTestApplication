package com.rzatha.sebbiatestapplication.data.network

import com.google.gson.annotations.SerializedName

data class NewsDetailResponse (
    @SerializedName("news") val news: NewsDto
)