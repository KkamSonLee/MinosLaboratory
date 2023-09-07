package com.angdroid.minoslaboratory.presentation.main.vm

import android.content.Context
import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.work.WorkManager
import com.angdroid.minoslaboratory.data.dto.MyData
import com.angdroid.minoslaboratory.domain.repository.main.MainRepository
import com.angdroid.minoslaboratory.domain.usecase.GetUserInfo
import com.angdroid.minoslaboratory.presentation.base.component.BaseMviViewModel
import com.angdroid.minoslaboratory.presentation.main.state.MainContract.MainSideEffect
import com.angdroid.minoslaboratory.presentation.main.state.MainContract.MainViewModelAction
import com.angdroid.minoslaboratory.presentation.main.state.MainContract.MainViewState
import com.angdroid.minoslaboratory.presentation.main.state.MainContract.MainViewStateImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import java.time.LocalDateTime
import java.util.UUID
import javax.inject.Inject


@HiltViewModel
class MainMviViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val getUserInfoUseCase: GetUserInfo, @ApplicationContext context: Context
) : BaseMviViewModel<MainViewState, MainViewModelAction, MainSideEffect>() {

    private val _state = MainViewStateImpl()
    override val state: MainViewState = _state

    private val _worker = WorkManager.getInstance(context)

    init {
        Log.e("LMH", "start Time ${LocalDateTime.now()}")
        /*val request =
            PeriodicWorkRequestBuilder<IntervalSendWorker>(15, TimeUnit.MINUTES, 1, TimeUnit.MINUTES).setConstraints(Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())
                .build()
        _worker.enqueue(request)*/
    }

    fun getHelloMessage() {
        viewModelScope.launch {
            val message = mainRepository.getHelloWorld()
            Timber.tag("LMH").e(message)
        }
    }

    fun getMessage() {
        viewModelScope.launch {
            val message = mainRepository.getMessage()
            Timber.tag("LMH").e("${message.id} : ${message.text}")
        }
    }

    fun postMessage() {
        viewModelScope.launch {
            val message = mainRepository.postMessage(MyData(UUID.randomUUID().toString(), "Mino!"))
            Timber.tag("LMH").e("${message.id} : ${message.text}")
        }
    }


    private fun fetchUserInfo() {
        viewModelScope.launch {
            _state.userData.update { getUserInfoUseCase.invoke("이민호") }
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

    override fun onCleared() {
        Log.e("LMH", "Main MVI onCleared()")
        _worker.cancelAllWork()
        super.onCleared()
    }
}