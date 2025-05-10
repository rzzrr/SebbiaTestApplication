package com.rzatha.sebbiatestapplication.domain

import java.time.Instant
import java.time.LocalDateTime
import java.util.Date

data class News(
    val id: Int,
    val title: String,
    val date: LocalDateTime,
    val shortDescription: String,
    val fullDescription: String?
)