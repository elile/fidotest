package com.example.fidotest.utils

import com.example.fidotest.data.local.entities.ArticleEntity
import com.example.fidotest.data.remote.dto.ArticleDto
import com.example.fidotest.presentation.model.ArticleUi

object ArticleMapper {

    fun dtoToEntity(dto: ArticleDto): ArticleEntity {
        return ArticleEntity(
            sourceName = dto.source?.name,
            sourceId = dto.source?.id,
            author = dto.author,
            title = dto.title,
            description = dto.description,
            url = dto.url,
            urlToImage = dto.urlToImage,
            publishedAt = dto.publishedAt,
            content = dto.content
        )
    }

    fun entityToUi(entity: ArticleEntity): ArticleUi {
        return ArticleUi(
            id = entity.id,
            title = entity.title.orEmpty(),
            author = entity.author ?: "Unknown",
            imageUrl = entity.urlToImage,
            publishedAt = entity.publishedAt.orEmpty(),
            description = entity.description,
            articleUrl = entity.url.orEmpty(),
            content = entity.content.orEmpty()
        )
    }

    fun dtoListToEntityList(dtos: List<ArticleDto>): List<ArticleEntity> {
        return dtos.map { dtoToEntity(it) }
    }

    fun entityListToUiList(entities: List<ArticleEntity>): List<ArticleUi> {
        return entities.map { entityToUi(it) }
    }
}
