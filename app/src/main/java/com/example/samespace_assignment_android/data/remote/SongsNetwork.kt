package com.example.samespace_assignment_android.data.remote

import com.example.samespace_assignment_android.data.local.Track
import com.example.samespace_assignment_android.data.local.Tracks
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class SongsNetwork {
    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys
                prettyPrint = true
                isLenient = true
            })
        }
    }

    suspend fun allSongs():List<Track> {
        val allSongs: Tracks = client.get("https://cms.samespace.com/items/songs") {
            contentType(ContentType.Application.Json)
        }.body()

        return allSongs.data
    }


}