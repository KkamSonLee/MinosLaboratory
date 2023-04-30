package com.angdroid.minoslaboratory.presentation.main.state

import com.angdroid.minoslaboratory.domain.entity.User
import com.angdroid.minoslaboratory.presentation.base.state.EventState
import com.angdroid.minoslaboratory.presentation.base.state.SideEffect
import com.angdroid.minoslaboratory.presentation.base.state.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object MainContract {

    interface MainViewState : ViewState {
        val userData: StateFlow<User>
    }

    data class MainViewStateImpl(
        override val userData: MutableStateFlow<User> = MutableStateFlow(User())
    ) : MainViewState

    sealed interface MainViewModelAction : EventState {
        object FetchUserData : MainViewModelAction
    }

    sealed interface MainSideEffect : SideEffect {
        object ShowToast : MainSideEffect
    }
}