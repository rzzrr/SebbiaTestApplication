package com.rzatha.sebbiatestapplication.data

import com.rzatha.sebbiatestapplication.data.network.NewsCategoryDto
import com.rzatha.sebbiatestapplication.data.network.NewsDto
import com.rzatha.sebbiatestapplication.domain.News
import com.rzatha.sebbiatestapplication.domain.NewsCategory

class Mapper {

    fun mapNewsCategoryDtoToNewsCategory(categoryDto: NewsCategoryDto) = NewsCategory(
        id = categoryDto.id,
        name = categoryDto.name
    )

    fun mapNewsDtoToNews(newsDto: NewsDto) = News(
        id = (newsDto.id).toInt(),
        title = newsDto.title,
        date = newsDto.date,
        shortDescription = newsDto.shortDescription,
        fullDescription = newsDto.fullDescription
    )

    fun mapNewsCategoryDtoListToNewsCategoryList(categoryDtoList: List<NewsCategoryDto>) =
        categoryDtoList.map { mapNewsCategoryDtoToNewsCategory(it) }

    fun mapNewsDtoListToNewsList(newsDtoList: List<NewsDto>) =
        newsDtoList.map { mapNewsDtoToNews(it) }

}