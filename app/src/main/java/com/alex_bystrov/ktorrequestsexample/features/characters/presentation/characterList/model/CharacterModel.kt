package com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList.model

data class CharacterModel(
    val id: Int,
    val name: String,
    val status: String,
    val gender: String,
    val imageUrl: String
)
