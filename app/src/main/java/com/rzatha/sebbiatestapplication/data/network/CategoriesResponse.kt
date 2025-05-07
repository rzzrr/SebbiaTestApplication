package com.rzatha.sebbiatestapplication.data.network

import com.google.gson.annotations.SerializedName

class CategoriesResponse(
    @SerializedName("list") val categoryList: List<NewsCategoryDto>
)
