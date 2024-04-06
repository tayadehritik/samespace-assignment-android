package com.example.samespace_assignment_android.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samespace_assignment_android.data.local.ForYouUIState
import com.example.samespace_assignment_android.data.local.Tracks
import com.example.samespace_assignment_android.data.remote.SongsNetwork
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ForYouViewModel: ViewModel()
{
    private val forYouUIState = MutableStateFlow(ForYouUIState())
    public val _forYouUIState = forYouUIState.asStateFlow()
    private val SongsNetwork = SongsNetwork()

    init {
        forYouUIState.value = ForYouUIState(is_loading = true, tracks = null)
        viewModelScope.launch {
            val tracks = SongsNetwork.allSongs()
            forYouUIState.value = ForYouUIState(is_loading = false, tracks = tracks)
        }

    }


}