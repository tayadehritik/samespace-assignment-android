package com.example.samespace_assignment_android.data.local

import kotlinx.serialization.Serializable

@Serializable
data class Track(
    val id: Int,
    val status: String,
    val sort: String?, // Change type if sort is not nullable
    val user_created: String,
    val date_created: String,
    val user_updated: String,
    val date_updated: String,
    val name: String,
    val artist: String,
    val accent: String,
    val cover: String,
    val top_track: Boolean,
    val url: String
)

@Serializable
data class Tracks(
    val data: List<Track>
)