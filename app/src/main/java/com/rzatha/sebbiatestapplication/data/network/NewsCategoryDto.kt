package com.rzatha.sebbiatestapplication.data.network

import com.google.gson.annotations.SerializedName

data class NewsCategoryDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)