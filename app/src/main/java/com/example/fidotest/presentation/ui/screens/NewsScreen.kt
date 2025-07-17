package com.example.fidotest.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fidotest.presentation.viewmodels.NewsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
    viewModel: NewsViewModel = koinViewModel()
) {
    val articles by viewModel.articles.collectAsState()

    Column(modifier = modifier.fillMaxSize()) {
        Button(onClick = { viewModel.refresh() }) {
            Text("Refresh")
        }

        LazyColumn {
            items(articles) { article ->
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = article.title, style = MaterialTheme.typography.titleMedium)
                    Text(text = article.author, style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}
