package com.alex_bystrov.ktorrequestsexample.features.characters.api.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class KtorDataSource(private val client: HttpClient): KtorRepository {

    override suspend fun getCharacter(id: Int): Character {
        return client.get("character/$id").body()
    }

    override suspend fun fetchAllCharacters(): KtorRequestModel {
        return client.get("character").body()
    }
}