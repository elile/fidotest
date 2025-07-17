package com.example.fidotest.domain.news

import com.example.fidotest.presentation.model.ArticleUi
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getArticles(): Flow<List<ArticleUi>>
    fun getArticle(id: Int): Flow<ArticleUi>

    suspend fun refreshArticles()
}