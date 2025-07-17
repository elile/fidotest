package com.example.fidotest.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fidotest.domain.news.NewsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NewsViewModel(
    private val repository: NewsRepository
) : ViewModel() {

    val articles = repository.getArticles()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun getArticleById(id: Int) = repository.getArticle(id)
        .stateIn(viewModelScope, SharingStarted.Lazily, null)

    fun refresh() {
        viewModelScope.launch {
            repository.refreshArticles()
        }
    }
}
