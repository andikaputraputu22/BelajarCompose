package com.moonlightsplitter.belajarcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonlightsplitter.belajarcompose.data.model.ProgrammerModel
import com.moonlightsplitter.belajarcompose.ui.theme.BelajarComposeTheme
import com.moonlightsplitter.belajarcompose.ui.theme.Quadrant1

class CardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BelajarComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Quadrant1
                ) {
                    val data = ProgrammerModel(
                        "Andika Putra",
                        "Android Programmer at Detikcom",
                        "081339891936",
                        "@andikaputraputu",
                        "andikaputraputu22@gmail.com"
                    )
                    CardName(data = data)
                }
            }
        }
    }
}

@Composable
fun CardName(data: ProgrammerModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .weight(6f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ContentName(data = data)
        }
        Column(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Info(icon = Icons.Rounded.Phone, data = data.phone)
            Info(icon = Icons.Rounded.Share, data = data.socialMedia)
            Info(icon = Icons.Rounded.Email, data = data.email)
        }
    }
}

@Composable
fun ContentName(data: ProgrammerModel) {
    val image = painterResource(R.drawable.android_logo)
    Box(
        modifier = Modifier
            .size(120.dp)
            .padding(8.dp)
            .background(color = Color.DarkGray, MaterialTheme.shapes.medium)
    ) {
        Image(painter = image, contentDescription = null)
    }
    Text(
        text = data.name,
        fontSize = 48.sp,
        fontWeight = FontWeight.Bold
    )
    Spacer(Modifier.height(8.dp))
    Text(
        text = data.job
    )
}

@Composable
fun Info(icon: ImageVector, data: String) {
    Spacer(Modifier.height(8.dp))
    Row {
        Icon(icon, contentDescription = null)
        Text(
            text = data,
            modifier = Modifier
                .padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    BelajarComposeTheme {
        val data = ProgrammerModel(
            "Andika Putra",
            "Android Programmer at Detikcom",
            "081339891936",
            "@andikaputraputu",
            "andikaputraputu22@gmail.com"
        )
        CardName(data = data)
    }
}