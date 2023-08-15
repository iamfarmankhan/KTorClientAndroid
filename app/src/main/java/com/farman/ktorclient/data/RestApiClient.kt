package com.farman.ktorclient.data

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json

class RestApiClient {
    fun getHttpClient() = HttpClient(Android){
        install(ContentNegotiation){
            json(

            )
            engine {
                connectTimeout = TIME_OUT
                socketTimeout = TIME_OUT
            }
        }

        install(Logging)

        install(DefaultRequest){
            header("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmNzkxMzExZTg2MGFkZmE0OGUxOGExZjg3NjFjZmY3ZCIsInN1YiI6IjY0Y2Y2ZTE5NmQ0Yzk3MDEyZThiMzZlOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.a4H7E5L4HAFPSoDL8juyBRqApZgvVjCf_2gIOE3wYAI")
        }
    }


    companion object {
        private const val TIME_OUT = 10_000
    }
}