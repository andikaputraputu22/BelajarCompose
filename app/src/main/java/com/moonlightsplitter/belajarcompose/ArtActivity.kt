package com.moonlightsplitter.belajarcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.moonlightsplitter.belajarcompose.data.model.ArtModel
import com.moonlightsplitter.belajarcompose.ui.theme.BelajarComposeTheme

val artList = listOf(
    ArtModel(R.drawable.art1, "Keagungan Tuhan yang maha kuasa", "William Tani"),
    ArtModel(R.drawable.art2, "Senyuman alam yang penuh kasih sayang", "Robert Lawnsky"),
    ArtModel(R.drawable.art3, "Membeku dan kedinginan yang luar biasa", "Susi Wibowo")
)

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
    var index by remember { mutableStateOf(0) }
    val size = artList.size
    val data = artList[index]
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .padding(start = 16.dp, end = 16.dp)
    ) {
        val (containerButton, containerDescription, containerImage) = createRefs()
        Image(
            painter = painterResource(data.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .constrainAs(containerImage) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top, margin = 16.dp)
                    bottom.linkTo(containerDescription.top, margin = 16.dp)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
        )
        Column(
            modifier = Modifier
                .constrainAs(containerDescription) {
                    start.linkTo(parent.start)
                    bottom.linkTo(containerButton.top)
                }
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = data.description,
                fontSize = 24.sp,
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = data.author,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                maxLines = 1
            )
        }
        Row(
            modifier = Modifier
                .constrainAs(containerButton) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                }
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    if (index > 0) {
                        index--
                    }
                }) {
                Text(
                    text = stringResource(R.string.previous)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    if (index < size - 1) {
                        index++
                    }
                }) {
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