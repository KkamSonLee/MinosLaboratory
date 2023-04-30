package com.angdroid.minoslaboratory.presentation.main.s

import com.angdroid.minoslaboratory.domain.entity.User
import com.angdroid.minoslaboratory.presentation.base.state.EventState
import com.angdroid.minoslaboratory.presentation.base.state.SideEffect
import com.angdroid.minoslaboratory.presentation.base.state.ViewState
import kotlinx.coroutines.flow.StateFlow

object MainContract {

    interface MainViewState : ViewState {
        val userData: StateFlow<User>
    }

    sealed interface MainViewModelAction : EventState {
        object FetchUserData : MainViewModelAction
    }

    sealed interface MainSideEffect : SideEffect {
        object ShowToast : MainSideEffect
    }
}