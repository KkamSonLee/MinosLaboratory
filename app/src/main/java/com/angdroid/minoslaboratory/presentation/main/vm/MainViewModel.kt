package com.angdroid.minoslaboratory.presentation.main.vm

import androidx.lifecycle.viewModelScope
import com.angdroid.minoslaboratory.domain.entity.User
import com.angdroid.minoslaboratory.presentation.base.component.BaseViewModel
import com.angdroid.minoslaboratory.domain.repository.main.MainRepository
import com.angdroid.minoslaboratory.presentation.main.s.MainContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


data class MainViewStateStateImpl(
    override val userData: MutableStateFlow<User> = MutableStateFlow(User())
) : MainContract.MainViewState

@HiltViewModel
class MainViewModel @Inject constructor(private val mainService: MainRepository) : BaseViewModel<MainContract.MainViewState, MainContract.MainViewModelAction, MainContract.MainSideEffect>() {

    private val _state = MainViewStateStateImpl()
    override val state: MainContract.MainViewState = _state

    private fun fetchUserInfo() {
        viewModelScope.launch {
            _state.userData.update { mainService.getUserInfo("이민호") }
            setEffect { MainContract.MainSideEffect.ShowToast }
        }
    }

    override fun handleEvents(event: MainContract.MainViewModelAction) {
        when (event) {
            MainContract.MainViewModelAction.FetchUserData -> { fetchUserInfo() }
            else -> {}
        }
    }
}