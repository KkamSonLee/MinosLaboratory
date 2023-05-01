package com.angdroid.minoslaboratory.presentation.base.component

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angdroid.minoslaboratory.presentation.base.state.EventState
import com.angdroid.minoslaboratory.presentation.base.state.SideEffect
import com.angdroid.minoslaboratory.presentation.base.state.ViewState
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseMviViewModel<S : ViewState, E : EventState, SE : SideEffect> : ViewModel() {
    abstract val state: S
    abstract fun handleEvents(event: E)

    private val _event = MutableSharedFlow<E>(
        extraBufferCapacity = Int.MAX_VALUE,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )

    private val _debounceEvent = MutableSharedFlow<E>(
        extraBufferCapacity = Int.MAX_VALUE,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )

    private val _effect: Channel<SE> = Channel()
    val effect = _effect.receiveAsFlow()

    protected fun setEffect(builder: () -> SE) {
        viewModelScope.launch {
            _effect.send(builder())
        }
    }

    fun emitEvent(event: E) {
        viewModelScope.launch {
            _event.emit(event)
        }
    }

    fun emitDelayEvent(event: E) {
        viewModelScope.launch {
            _debounceEvent.emit(event)
        }
    }

    private fun collectEvents() {
        viewModelScope.launch {
            _event.collect { handleEvents(it) }
        }
    }

    private fun collectDebounceEvent() {
        viewModelScope.launch {
            _debounceEvent.debounce(2000).map { listOf(it) }.flatMapConcat { it.asFlow() }.collect { handleEvents(it) }
        }
    }

    init {
        collectEvents()
        collectDebounceEvent()
    }
}