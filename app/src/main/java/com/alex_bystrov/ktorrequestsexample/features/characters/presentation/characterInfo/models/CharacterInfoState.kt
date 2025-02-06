package com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterInfo.models

data class CharacterInfoState(
    val imageUrl: String = "",
    val name : String = "",
    val status: String = "",
    val species: String = "",
    val type: String = "",
    val gender: String = ""
)