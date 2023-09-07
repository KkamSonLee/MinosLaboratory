package com.angdroid.minoslaboratory.presentation.main.vm

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.angdroid.minoslaboratory.presentation.base.state.EventState
import com.angdroid.minoslaboratory.presentation.base.state.ViewState
import com.angdroid.minoslaboratory.presentation.main.worker.IntervalSendWorker
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import java.util.concurrent.TimeUnit
import javax.inject.Inject

interface SampleViewState : ViewState {
    val name: StateFlow<String>
}

data class SampleViewStateImpl(override val name: MutableStateFlow<String> = MutableStateFlow<String>("")) : SampleViewState

class SampleViewModel @Inject constructor(@ApplicationContext context: Context) : ViewModel() {

    init {
        Log.e("LMH", "init ViewModel")
    }

    private val _worker = WorkManager.getInstance(context)
    val worker = _worker.getWorkInfosByTag("WORKER")

    private val _event = MutableSharedFlow<EventState>(extraBufferCapacity = Int.MAX_VALUE, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val event get() = _event.asSharedFlow()

    private val _viewState = SampleViewStateImpl()
    val viewState get():SampleViewState = _viewState

    fun applyWorkManager() {
        val request =
            PeriodicWorkRequestBuilder<IntervalSendWorker>(15, TimeUnit.MINUTES, 1, TimeUnit.MINUTES).addTag("WORKER").setConstraints(Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())
                .build()
        _worker.enqueue(request)
    }

    fun sendEvent(eventState: EventState) {
        _event.tryEmit(eventState)
    }

    override fun onCleared() {
        super.onCleared()
    }
}