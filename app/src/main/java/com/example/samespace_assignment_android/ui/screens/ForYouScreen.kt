package com.example.samespace_assignment_android.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.systemGesturesPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

import coil.compose.AsyncImage
import com.example.samespace_assignment_android.data.local.Track
import com.example.samespace_assignment_android.ui.common.LoadingDialog
import com.example.samespace_assignment_android.ui.common.TrackItem
import com.example.samespace_assignment_android.ui.viewmodels.ForYouViewModel

private val viewModel: ForYouViewModel = ForYouViewModel()
@Preview
@Composable
fun ForYouScreen()
{
    val forYouUIState by viewModel._forYouUIState.collectAsState()

    if(forYouUIState.is_loading)
    {
        LoadingDialog(text = "Fetching tracks")
    }
    else {
        


        LazyColumn(
            modifier = Modifier
                .statusBarsPadding()
                .padding(24.dp, 0.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        )
        {

            items(forYouUIState.tracks!!.size) {
                TrackItem(
                    name = forYouUIState.tracks!![it].name,
                    artist = forYouUIState.tracks!![it].artist,
                    cover = forYouUIState.tracks!![it].cover
                )
            }
        }

    }

    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(

            Brush.verticalGradient(
                colors = listOf(Color.Transparent, Color.Transparent, Color.Black),
                startY = this.size.center.y
            )

        )

    }
}




