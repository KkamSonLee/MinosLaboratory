package com.angdroid.minoslaboratory.presentation.main.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import com.angdroid.minoslaboratory.presentation.base.state.EventState
import com.angdroid.minoslaboratory.presentation.base.state.ViewState
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

interface SampleViewState : ViewState {
    val name: StateFlow<String>
}

data class SampleViewStateImpl(override val name: MutableStateFlow<String> = MutableStateFlow<String>("")) : SampleViewState

class SampleViewModel @Inject constructor() : ViewModel() {

    init {
        Log.e("LMH", "init ViewModel")
    }

    private val _event = MutableSharedFlow<EventState>(extraBufferCapacity = Int.MAX_VALUE, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val event get() = _event.asSharedFlow()

    private val _viewState = SampleViewStateImpl()
    val viewState get():SampleViewState = _viewState


    fun sendEvent(eventState: EventState) {
        _event.tryEmit(eventState)
    }
}