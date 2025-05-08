package com.rzatha.sebbiatestapplication.data.network

import com.google.gson.annotations.SerializedName

data class NewsDto (
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("date") val date: String,
    @SerializedName("shortDescription") val shortDescription: String,
    @SerializedName("fullDescription") val fullDescription: String?
)
