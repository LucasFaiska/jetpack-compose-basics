package com.lfaiska.jetpack.compose.basics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.lfaiska.jetpack.compose.basics.ui.JetpackComposeBasicsTheme
import com.lfaiska.jetpack.compose.basics.ui.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsStory()
        }
    }
}

@Composable
fun NewsStory() {
    JetpackComposeBasicsTheme {
        Column(
                modifier = Modifier.padding(16.dp)
        ) {
            Header()

            Text("A day wandering through the sandhills " +
                    "in Shark Fin Cove, and a few of the " +
                    "sights I saw",
                    style = typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis)

            Text("Davenport, California",
                    style = typography.body2)

            Text("December 2018",
                    style = typography.body2)
        }
    }
}

@Composable
fun Header() {
    val image = imageResource(id = R.drawable.header)

    val imageModifier = Modifier
            .preferredHeight(180.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp))

    Image(image, modifier = imageModifier,
            contentScale = ContentScale.Crop)

    Spacer(Modifier.preferredHeight(16.dp))
}

@Preview(showDecoration = true, showBackground = true)
@Composable
fun DefaultPreview() {
    NewsStory()
}
