package com.angdroid.minoslaboratory.presentation.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

inline fun <T, R: LifecycleOwner> R.collectFlow(
    flow: Flow<T>, state: Lifecycle.State = Lifecycle.State.STARTED, crossinline block: suspend (T) -> Unit
) {
    when (this) {
        is AppCompatActivity -> {
            flow.flowWithLifecycle(lifecycle, state).onEach { block(it) }.launchIn(lifecycleScope)
        }
        is Fragment -> {
            flow.flowWithLifecycle(viewLifecycleOwner.lifecycle, state).onEach { block(it) }
                .launchIn(viewLifecycleOwner.lifecycleScope)
        }
        else -> {}
    }
}

fun LifecycleOwner.repeatOnStarted(state: Lifecycle.State = Lifecycle.State.STARTED, block: suspend CoroutineScope.() -> Unit) {
    lifecycleScope.launch {
        lifecycle.repeatOnLifecycle(state, block)
    }
}
