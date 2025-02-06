package com.alex_bystrov.ktorrequestsexample.features.characters.api

import com.alex_bystrov.ktorrequestsexample.features.characters.api.ktor.Character
import com.alex_bystrov.ktorrequestsexample.features.characters.api.ktor.KtorRepository
import com.alex_bystrov.ktorrequestsexample.features.characters.api.ktor.mapToCharacterModel


class CharacterRepositoryImpl(private val repository: KtorRepository): CharacterRepository {
    override suspend fun getCharacter(id: Int): Character {
        return repository.getCharacter(id)
    }

    override suspend fun fetchAllCharacters(): List<Character> {
        return repository.fetchAllCharacters().results
    }
}