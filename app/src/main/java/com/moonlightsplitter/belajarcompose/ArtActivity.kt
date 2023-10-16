package com.moonlightsplitter.belajarcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.moonlightsplitter.belajarcompose.ui.theme.BelajarComposeTheme

class ArtActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BelajarComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ParentContent()
                }
            }
        }
    }
}

@Composable
fun ParentContent() {
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .padding(start = 16.dp, end = 16.dp)
    ) {
        val (containerButton, containerDescription, containerImage) = createRefs()
        val bottomGuideLine = createGuidelineFromBottom(16.dp)
        val topGuideLine = createGuidelineFromTop(16.dp)
        Image(
            painter = painterResource(id = R.drawable.art1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .constrainAs(containerImage) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(topGuideLine)
                }
                .fillMaxWidth()
        )
        Column(
            modifier = Modifier
                .constrainAs(containerDescription) {
                    start.linkTo(parent.start)
                    bottom.linkTo(containerButton.top)
                }
                .fillMaxWidth()
                .padding(bottom = 64.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Test Test",
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Hallo",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
        Row(
            modifier = Modifier
                .constrainAs(containerButton) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(bottomGuideLine)
                }
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {}) {
                Text(
                    text = stringResource(R.string.previous)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                modifier = Modifier.weight(1f),
                onClick = {}) {
                Text(
                    text = stringResource(R.string.next)
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    BelajarComposeTheme {
        ParentContent()
    }
}