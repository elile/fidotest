package com.example.fidotest.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.fidotest.presentation.model.ArticleUi

@Composable
fun ArticleRow(modifier: Modifier = Modifier, article: ArticleUi, onClick: (Int) -> Unit) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .clickable(onClick = { onClick(article.id) })
    ) {
        // Background Image
        AsyncImage(
            model = article.imageUrl,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Gradient overlay for better text visibility
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.6f)),
                        startY = 50f
                    )
                )
        )

        // Text content
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(12.dp)
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.titleMedium.copy(color = Color.White),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "${article.publishedAt} • ${article.author}",
                style = MaterialTheme.typography.bodySmall.copy(color = Color.White.copy(alpha = 0.8f)),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    showBackBtn: Boolean,
    onBackClick: () -> Unit,
) {

    TopAppBar(modifier = Modifier.fillMaxWidth(), title = {
        Text(title)
    }, navigationIcon = {
        if (showBackBtn) {
            Icon(
                modifier = Modifier.clickable {
                    onBackClick()
                },
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    })
}


@Preview
@Composable
fun ArticleRowPreview() {
    val article = ArticleUi(
        id = 1,
        title = "Républicains et fidèles de Trump se publication des fichiers Epstein",
        author = "Julie Malo",
        imageUrl = "https://static.lpnt.fr/images/2025/07/16/27666111lpw-27666120-mega-une-jpg_11250565.jpg",
        publishedAt = "2025-07-16 11:00",
        description = "Le camp de Donald Trump se fissure, alors qu'une partie du mouvement Maga reclame la publication integrale des dossiers relatifs a Jeffrey Epstein.",
        articleUrl = "https://www.lepoint.fr/monde/republicains-et-fideles-de-trump-se-dechirent-sur-la-publication-des-fichiers-epstein-16-07-2025-2594538_24.php",
        content = "C'est une sacrée épine dans le pied de Donald Trump et ses équipes. Depuis plusieurs jours, le camp républicain se déchire sur la question de la publication des dossiers Epstein. Parlementaires comme… [+4709 chars]"
    )
    ArticleRow(article = article) {

    }

}