package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.ui.theme.GreetingCardTheme

class MyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Drawing starts from here
        setContent {
            GreetingCardTheme {
                Scaffold { paddingValues ->
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_string),
                        from = stringResource(R.string.signature_text),
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }
    }
}


@Composable
fun GreetingText(name: String, from: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = name,
            fontSize = 80.sp,
            lineHeight = 100.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box (modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.7f
        )
        GreetingText(
            name = message,
            from = from,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingTextPreview() {
    GreetingCardTheme {
        GreetingText(
            name = stringResource(R.string.happy_birthday_string),
            from = stringResource(R.string.signature_text),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    GreetingCardTheme {
        GreetingImage(
            message = stringResource(R.string.happy_birthday_string),
            from = stringResource(R.string.signature_text),
        )
    }
}