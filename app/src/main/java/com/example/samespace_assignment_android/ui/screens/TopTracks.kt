package com.example.samespace_assignment_android.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.systemGesturesPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samespace_assignment_android.ui.common.LoadingDialog
import com.example.samespace_assignment_android.ui.common.TrackItem
import com.example.samespace_assignment_android.ui.viewmodels.ForYouViewModel

private val viewModel: ForYouViewModel = ForYouViewModel()
@Preview
@Composable
fun TopTracks()
{
    val forYouUIState by viewModel._forYouUIState.collectAsState()


    if(forYouUIState.is_loading)
    {
        LoadingDialog(text = "Fetching tracks")
    }
    else
    {
        val reversedTracks = forYouUIState.tracks!!.asReversed()

        LazyColumn(
            modifier = Modifier.statusBarsPadding().padding(24.dp,0.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        )
        {

            items(reversedTracks.size) {
                TrackItem(name = reversedTracks[it].name,
                    artist = reversedTracks[it].artist,
                    cover = reversedTracks[it].cover)
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