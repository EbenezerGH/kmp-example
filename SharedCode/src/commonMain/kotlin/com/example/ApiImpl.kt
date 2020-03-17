package com.example

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON

class ApiImpl(private val engine: HttpClientEngine) {
    private val client by lazy {
        HttpClient(engine) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(JSON.nonstrict)
            }
        }
    }

    suspend fun fetchApi(): Comic {
        return client.get<Comic> {
            url("$baseUrl/info.0.json")
        }
    }

    companion object {
        private const val baseUrl = "https://xkcd.com"
    }

    @Serializable
    data class Comic(
        val alt: String,
        val day: String,
        val img: String,
        val link: String,
        val month: String,
        val news: String,
        val num: String,
        val safe_title: String,
        val transcript: String,
        val year: String
    )
}
