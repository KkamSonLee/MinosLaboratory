package com.angdroid.minoslaboratory.presentation.main.vm

import android.content.Context
import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.angdroid.minoslaboratory.presentation.base.component.BaseMviViewModel
import com.angdroid.minoslaboratory.domain.repository.main.MainRepository
import com.angdroid.minoslaboratory.presentation.main.state.MainContract.MainSideEffect
import com.angdroid.minoslaboratory.presentation.main.state.MainContract.MainViewState
import com.angdroid.minoslaboratory.presentation.main.state.MainContract.MainViewStateImpl
import com.angdroid.minoslaboratory.presentation.main.state.MainContract.MainViewModelAction
import com.angdroid.minoslaboratory.presentation.main.worker.IntervalSendWorker
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject


@HiltViewModel
class MainMviViewModel @Inject constructor(private val mainService: MainRepository, @ApplicationContext context:Context) : BaseMviViewModel<MainViewState, MainViewModelAction, MainSideEffect>() {

    private val _state = MainViewStateImpl()
    override val state: MainViewState = _state

    private val _worker = WorkManager.getInstance(context)

    init {
        val request = PeriodicWorkRequestBuilder<IntervalSendWorker>(15, TimeUnit.MINUTES, 1, TimeUnit.MINUTES).setConstraints(Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build()
        _worker.enqueue(request)
    }


    private fun fetchUserInfo() {
        viewModelScope.launch {
            _state.userData.update { mainService.getUserInfo("이민호") }
            setEffect { MainSideEffect.ShowToast }
        }
    }

    override fun handleEvents(event: MainViewModelAction) {
        Log.e("LMH", "Catch Event $event")
        when (event) {
            MainViewModelAction.FetchUserData -> {
                fetchUserInfo()
            }
            else -> {}
        }
    }
}