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
            header("Authorization","Bearer API_TOKEN_HERE")
        }
    }


    companion object {
        private const val TIME_OUT = 10_000
    }
}
