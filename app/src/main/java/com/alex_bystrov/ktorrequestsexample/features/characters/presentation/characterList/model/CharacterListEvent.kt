package com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList.model

sealed class CharacterListEvent {
    data object Init: CharacterListEvent()
}