package com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList.composables.CharacterCard
import com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList.composables.NoCharacterItem
import com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList.model.CharacterListEvent
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterListScreen(
    modifier: Modifier = Modifier,
    viewModel: CharacterListViewModel = koinViewModel<CharacterListViewModel>()
) {
    val state by viewModel.viewStates().collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(event = CharacterListEvent.Init)
    }

    if (state.characters.isEmpty()) {
        NoCharacterItem(modifier = modifier.fillMaxSize())
    }

    AnimatedVisibility(
        visible = !state.isLoading,
        enter = slideInVertically(
            animationSpec = tween(2000),
            initialOffsetY = { -40 }
        ) + expandVertically(expandFrom = Alignment.Top)
                + scaleIn(
            transformOrigin = TransformOrigin(0.5f, 0f)
        ) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutHorizontally() + shrinkVertically() + fadeOut() + scaleOut(
            targetScale = 1.2F
        )
    ) {
        LazyColumn(
            modifier = modifier.fillMaxSize()
        ) {
            items(
                items = state.characters,
                key = { model ->
                    model.id
                }
            ) { character ->
                CharacterCard(
                    model = character
                ) {

                }
            }
        }
    }
}
