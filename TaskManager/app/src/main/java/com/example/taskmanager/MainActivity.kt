package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TaskManager(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TaskManager(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        ShowImage()
        Heading()
        Content()
    }
}

@Composable
fun ShowImage() {
    val image = painterResource(R.drawable.ic_task_completed)

    Image(
        painter = image,
        contentDescription = null
    )
}

@Composable
fun Heading() {
    Text(
        text = stringResource(R.string.heading),
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(24.dp, 8.dp)
    )
}

@Composable
fun Content() {
    Text(
        text = stringResource(R.string.content),
        fontSize = 16.sp
    )
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewShowImage() {
    TaskManager()
}