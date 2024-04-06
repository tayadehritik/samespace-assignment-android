package com.example.samespace_assignment_android.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Preview
@Composable
fun TrackItem(
    name:String = "test",
    artist:String = "test",
    cover:String = "test"
)
{
    Row(

        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 6.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        AsyncImage(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape),
            model = "https://cms.samespace.com/assets/$cover",
            contentDescription = "Hello",
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.height(48.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        )
        {
            Text(

                text = name,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = artist,
                    style = MaterialTheme.typography.labelMedium
            )
        }

    }
}