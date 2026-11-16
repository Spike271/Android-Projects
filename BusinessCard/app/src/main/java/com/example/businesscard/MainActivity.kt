package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import com.example.businesscard.ui.theme.AndroidGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        MainInformationPart(
            name = stringResource(R.string.name),
            description = stringResource(R.string.desc),
            modifier = Modifier.align(Alignment.Center)
        )
        ContactInformation(
            phoneNumber = stringResource(R.string.phone_number),
            linkedinId = stringResource(R.string.linkdin_id),
            email = stringResource(R.string.email),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 28.dp)
        )
    }
}

@Composable
fun MainInformationPart(name: String, description: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .size(250.dp)
                .padding(bottom = 15.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.my_image),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
        }
        Text(
            text = name,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = description,
            fontSize = 16.sp,
            color = AndroidGreen
        )
    }
}

@Composable
fun ContactInformation(
    phoneNumber: String,
    linkedinId: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.padding(8.dp)) {
            Icon(
                Icons.Default.Phone,
                contentDescription = null
            )
            Text(phoneNumber, fontSize = 16.sp, modifier = Modifier.padding(start = 16.dp))
        }
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painterResource(R.drawable.linkedin),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Text(linkedinId, fontSize = 16.sp, modifier = Modifier.padding(start = 16.dp))
        }
        Row(modifier = Modifier.padding(8.dp)) {
            Icon(
                Icons.Outlined.Email,
                contentDescription = null
            )
            Text(email, fontSize = 16.sp, modifier = Modifier.padding(start = 16.dp))
        }
    }
}

@Preview(device = "spec:parent=pixel_10,navigation=buttons", showSystemUi = true, showBackground = true)
@Composable
private fun PreviewMainInfoPart() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        MainScreen(modifier = Modifier.padding(innerPadding))
    }
}