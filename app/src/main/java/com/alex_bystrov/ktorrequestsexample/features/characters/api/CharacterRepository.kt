package com.alex_bystrov.ktorrequestsexample.features.characters.api

import com.alex_bystrov.ktorrequestsexample.features.characters.api.ktor.Character


interface CharacterRepository {

    suspend fun getCharacter(id: Int): Character

    suspend fun fetchAllCharacters(): List<Character>
}