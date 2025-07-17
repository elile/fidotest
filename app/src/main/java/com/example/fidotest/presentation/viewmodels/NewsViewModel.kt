package com.example.fidotest.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fidotest.domain.news.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NewsViewModel(
    private val repository: NewsRepository
) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    val articles = repository.getArticles()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun getArticleById(id: Int) = repository.getArticle(id)
        .stateIn(viewModelScope, SharingStarted.Lazily, null)

    fun refresh() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                repository.refreshArticles()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
