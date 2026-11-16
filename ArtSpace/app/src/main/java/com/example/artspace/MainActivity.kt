package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.artspace.data.Images
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtGallery(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ImageInsideBox(@DrawableRes imageId: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .border(Dp.Hairline, Color.Black)
        ) {
            Image(
                painter = painterResource(imageId),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
        }
    }
}

@Composable
fun PreviousAndNextButton(onPreviousClick: () -> Unit, onNextClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(48.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Button(
            onClick = onPreviousClick,
            shape = RoundedCornerShape(50),
            modifier = Modifier.weight(1f)
        ) {
            Text("Previous")
        }
        Button(
            onClick = onNextClick,
            shape = RoundedCornerShape(50),
            modifier = Modifier.weight(1f)
        ) {
            Text("Next")
        }
    }
}

@Composable
fun ArtGallery(modifier: Modifier = Modifier) {
    var imageId by remember { mutableIntStateOf(0) }
    val onPreviousClick: () -> Unit = {
        imageId = if (imageId > 0) {
            imageId - 1
        } else {
            Images.images.size - 1
        }
    }
    val onNextClick: () -> Unit = {
        imageId = (imageId + 1) % Images.images.size
    }

    Column(
        modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center
    ) {
        ImageInsideBox(Images.images[imageId])
        PreviousAndNextButton(onPreviousClick, onNextClick)
    }
}

@Preview(device = "spec:parent=pixel_5", apiLevel = 37, showSystemUi = true)
@Composable
private fun PreviewImageInsideBox() {
    ArtSpaceTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ArtGallery(Modifier.padding(innerPadding))
        }
    }
}