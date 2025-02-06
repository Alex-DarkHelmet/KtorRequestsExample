package com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList.composables.CharacterCard
import com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList.composables.NoCharacterItem
import com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList.model.CharacterListEvent
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterListScreen(
    viewModel: CharacterListViewModel = koinViewModel<CharacterListViewModel>()
) {
    val state by viewModel.viewStates().collectAsState()

    if (state.characters.isEmpty()) {
        NoCharacterItem()
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(event = CharacterListEvent.Init)
    }


    if (state.characters.isEmpty()) {
        NoCharacterItem()
    }
    LazyColumn {
        items(
            items = state.characters,
            key = { model ->
                model.id
            }
        ) { character ->
            CharacterCard(model = character) {

            }
        }
    }
}
