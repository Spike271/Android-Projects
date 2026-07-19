package com.example.quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrant.ui.theme.QuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuadrantApp(innerPadding)
                }
            }
        }
    }
}

@Composable
fun QuadrantApp(paddingValues: PaddingValues) {
    Column(Modifier.fillMaxWidth().padding(paddingValues)) {
        Row(Modifier.weight(1f)) {
            Quadrant(
                title = stringResource(R.string.first_title),
                description = stringResource(R.string.first_description),
                backgroundColor = colorResource(R.color.white_200),
                modifier = Modifier.weight(1f)
            )

            Quadrant(
                title = stringResource(R.string.second_title),
                description = stringResource(R.string.second_description),
                backgroundColor = colorResource(R.color.light_purple),
                modifier = Modifier.weight(1f)
            )
        }

        Row(Modifier.weight(1f)) {
            Quadrant(
                title = stringResource(R.string.third_title),
                description = stringResource(R.string.third_description),
                backgroundColor = colorResource(R.color.purple),
                modifier = Modifier.weight(1f)
            )

            Quadrant(
                title = stringResource(R.string.fourth_title),
                description = stringResource(R.string.fourth_description),
                backgroundColor = colorResource(R.color.purple_white),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun Quadrant(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview
@Composable
private fun PreviewFirstQuadrant() {
    QuadrantTheme {
        QuadrantApp(PaddingValues(16.dp))
    }
}