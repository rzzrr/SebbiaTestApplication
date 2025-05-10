package com.rzatha.sebbiatestapplication.data.network

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.util.Date

data class NewsDto (
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("date") val date: LocalDateTime,
    @SerializedName("shortDescription") val shortDescription: String,
    @SerializedName("fullDescription") val fullDescription: String?
)
