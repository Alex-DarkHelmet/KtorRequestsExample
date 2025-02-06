package com.alex_bystrov.ktorrequestsexample.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class CoreViewModel<State, Event, Action>(initialState: State) : ViewModel() {
    private val _viewState = MutableStateFlow(initialState)
    private val _viewAction =
        MutableSharedFlow<Action?>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    protected var viewState: State
        get() = _viewState.value
        set(value) {
            _viewState.value = value
        }

    protected var viewAction: Action?
        get() = _viewAction.replayCache.last()
        set(value) {
            _viewAction.tryEmit(value)
        }

    abstract fun onEvent(event: Event)

    fun viewStates(): StateFlow<State> = _viewState.asStateFlow()

    fun viewAction(): SharedFlow<Action?> = _viewAction.asSharedFlow()

    fun clearActions() {
        viewAction = null
    }

}