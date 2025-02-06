package com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList.model

data class CharacterListState(
    val isLoading: Boolean = false,
    val characters: List<CharacterModel> = emptyList()
)
