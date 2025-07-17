package com.example.fidotest.presentation.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.fidotest.presentation.viewmodels.NewsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewsDetailsScreen(viewModel: NewsViewModel, id: Int) {
    val article by viewModel.getArticleById(id).collectAsState()
    val context = LocalContext.current

    article?.let { news ->

        Column(modifier = Modifier.fillMaxSize()) {
            // Top Image with Overlay
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                AsyncImage(
                    model = news.imageUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Gradient for text readability
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f)),
                                startY = 100f
                            )
                        )
                )

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                ) {
                    Text(
                        text = news.title,
                        style = MaterialTheme.typography.headlineSmall.copy(color = Color.White),
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "${news.publishedAt} • ${news.author}",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.White.copy(
                                alpha = 0.9f
                            )
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Article Description and URL
            Column(modifier = Modifier.padding(16.dp)) {
                news.description?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Start
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Clickable URL
                Text(
                    text = "Read Full Article",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(news.articleUrl))
                        context.startActivity(intent)
                    }
                )
            }
        }
    } ?: run {
        // Loading state
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}

@Preview
@Composable
fun NewsDetailsScreenPreview() {
//    NewsDetailsScreen(id = 1)
}
