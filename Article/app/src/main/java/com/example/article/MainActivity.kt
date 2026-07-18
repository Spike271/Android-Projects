package com.example.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.article.ui.theme.ArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Drawing starts from here
        setContent {
            ArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArticleApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleApp(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        TopImage()
        Heading()
        FirstDescription()
        SecondDescription()
    }
}

@Composable
fun TopImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)

    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
    )
}

@Composable
fun Heading(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.title),
        fontSize = 24.sp,
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun FirstDescription(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.content_description_1),
        textAlign = TextAlign.Justify,
        modifier = modifier.padding(16.dp, 16.dp)
    )
}

@Composable
fun SecondDescription(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.content_description_2),
        textAlign = TextAlign.Justify,
        modifier = modifier.padding(16.dp)
    )
}