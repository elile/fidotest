package com.example.fidotest.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fidotest.presentation.ui.components.ArticleRow
import com.example.fidotest.presentation.viewmodels.NewsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
    viewModel: NewsViewModel = koinViewModel(),
    onArticleClick: (Int) -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.refresh()
    }
    val articles by viewModel.articles.collectAsState()

    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(articles) { article ->
                ArticleRow(article = article) {
                    onArticleClick(it)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
