package com.rzatha.sebbiatestapplication.domain

data class News(
    val id: Int,
    val title: String,
    val date: String,
    val shortDescription: String,
    val fullDescription: String?
)