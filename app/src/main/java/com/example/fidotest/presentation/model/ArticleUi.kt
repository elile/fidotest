package com.example.fidotest.presentation.model

data class ArticleUi(
    val title: String,
    val author: String,
    val imageUrl: String?,
    val publishedAt: String,
    val description: String?,
    val articleUrl: String
)
