package com.moonlightsplitter.belajarcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.moonlightsplitter.belajarcompose.ui.theme.BelajarComposeTheme
import com.moonlightsplitter.belajarcompose.ui.theme.Quadrant1
import com.moonlightsplitter.belajarcompose.ui.theme.Quadrant2
import com.moonlightsplitter.belajarcompose.ui.theme.Quadrant3
import com.moonlightsplitter.belajarcompose.ui.theme.Quadrant4

class QuadrantActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BelajarComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quadrant()
                }
            }
        }
    }
}

@Composable
fun Quadrant() {
    Column {
        Box(modifier = Modifier.weight(1f)) {
            RowContent1()
        }
        Box(modifier = Modifier.weight(1f)) {
            RowContent2()
        }
    }
}

@Composable
fun RowContent1() {
    Row {
        Box(modifier = Modifier.weight(1f)) {
            BoxContent(
                backgroundColor = Quadrant1,
                title = stringResource(R.string.title_quadrant1),
                description = stringResource(R.string.description_quadrant1)
            )
        }
        Box(modifier = Modifier.weight(1f)) {
            BoxContent(
                backgroundColor = Quadrant2,
                title = stringResource(R.string.title_quadrant2),
                description = stringResource(R.string.description_quadrant2)
            )
        }
    }
}

@Composable
fun RowContent2() {
    Row {
        Box(modifier = Modifier.weight(1f)) {
            BoxContent(
                backgroundColor = Quadrant3,
                title = stringResource(R.string.title_quadrant3),
                description = stringResource(R.string.description_quadrant3)
            )
        }
        Box(modifier = Modifier.weight(1f)) {
            BoxContent(
                backgroundColor = Quadrant4,
                title = stringResource(R.string.title_quadrant4),
                description = stringResource(R.string.description_quadrant4)
            )
        }
    }
}

@Composable
fun BoxContent(backgroundColor: Color, title: String, description: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = backgroundColor)
            .padding(16.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = description,
            color = Color.Black,
            textAlign = TextAlign.Justify
        )
    }
}