package com.rzatha.sebbiatestapplication.data

import com.rzatha.sebbiatestapplication.data.network.NewsCategoryDto
import com.rzatha.sebbiatestapplication.domain.NewsCategory

class Mapper {

    fun mapNewsCategoryDtoToNewsCategory(categoryDto: NewsCategoryDto) = NewsCategory(
        id = categoryDto.id,
        name = categoryDto.name
    )

    fun mapNewsCategoryDtoListToNewsCategoryList(categoryDtoList: List<NewsCategoryDto>) =
        categoryDtoList.map { mapNewsCategoryDtoToNewsCategory(it) }

}