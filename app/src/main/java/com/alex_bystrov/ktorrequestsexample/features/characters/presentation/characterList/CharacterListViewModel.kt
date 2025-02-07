package com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList

import androidx.lifecycle.viewModelScope
import com.alex_bystrov.ktorrequestsexample.common.CoreViewModel
import com.alex_bystrov.ktorrequestsexample.features.characters.api.CharacterRepository
import com.alex_bystrov.ktorrequestsexample.features.characters.api.ktor.mapToCharacterModel
import com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList.model.CharacterListEvent
import com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList.model.CharacterListState
import kotlinx.coroutines.launch

class CharacterListViewModel(
    private val repository: CharacterRepository
) : CoreViewModel<CharacterListState, CharacterListEvent, Unit>(initialState = CharacterListState()) {
    override fun onEvent(event: CharacterListEvent) {
        when (event) {
            CharacterListEvent.Init -> fetchData()
        }
    }

    private fun fetchData() {
        viewModelScope.launch {
            viewState = viewState.copy(isLoading = true)
            val fetchAllCharacters = repository.fetchAllCharacters().map { it.mapToCharacterModel() }

            viewState = viewState.copy(characters = fetchAllCharacters, isLoading = false)
        }
    }
}