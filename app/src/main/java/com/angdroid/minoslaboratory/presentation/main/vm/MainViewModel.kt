package com.angdroid.minoslaboratory.presentation.main.vm

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.angdroid.minoslaboratory.presentation.base.component.BaseViewModel
import com.angdroid.minoslaboratory.domain.repository.main.MainRepository
import com.angdroid.minoslaboratory.presentation.main.state.MainContract.MainSideEffect
import com.angdroid.minoslaboratory.presentation.main.state.MainContract.MainViewState
import com.angdroid.minoslaboratory.presentation.main.state.MainContract.MainViewStateImpl
import com.angdroid.minoslaboratory.presentation.main.state.MainContract.MainViewModelAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val mainService: MainRepository) : BaseViewModel<MainViewState, MainViewModelAction, MainSideEffect>() {

    private val _state = MainViewStateImpl()
    override val state: MainViewState = _state

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