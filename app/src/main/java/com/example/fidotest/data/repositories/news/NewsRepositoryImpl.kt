package com.example.fidotest.data.repositories.news

import com.example.fidotest.data.local.dao.ArticleDao
import com.example.fidotest.data.remote.api.NewsApiService
import com.example.fidotest.domain.news.NewsRepository
import com.example.fidotest.presentation.model.ArticleUi
import com.example.fidotest.utils.ArticleMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NewsRepositoryImpl(
    private val apiService: NewsApiService,
    private val articleDao: ArticleDao
) : NewsRepository {

    override fun getArticles(): Flow<List<ArticleUi>> {
        return articleDao.getAllArticles()
            .map { entities -> ArticleMapper.entityListToUiList(entities) }
    }

    override suspend fun refreshArticles() {
        val response = apiService.getEverything()
        val entities =
            response.articles?.let { ArticleMapper.dtoListToEntityList(it) } ?: emptyList()
        articleDao.clearArticles()
        articleDao.insertArticles(entities)
    }
}
