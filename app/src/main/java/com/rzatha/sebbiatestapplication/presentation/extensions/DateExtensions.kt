package com.rzatha.sebbiatestapplication.presentation.extensions

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun LocalDateTime.formatToUi() =
    this.format(DateTimeFormatter.ofPattern("HH:mm\ndd.MM.yyyy"))
