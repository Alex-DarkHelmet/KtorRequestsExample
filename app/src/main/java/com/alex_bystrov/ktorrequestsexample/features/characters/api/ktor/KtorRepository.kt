package com.alex_bystrov.ktorrequestsexample.features.characters.api.ktor

interface KtorRepository {
    suspend fun getCharacter(id: Int): Character

    suspend fun fetchAllCharacters(): KtorRequestModel
}