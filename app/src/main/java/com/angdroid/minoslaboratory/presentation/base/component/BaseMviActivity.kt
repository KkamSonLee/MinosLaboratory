package com.angdroid.minoslaboratory.presentation.base.component

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.angdroid.minoslaboratory.presentation.base.state.EventState
import com.angdroid.minoslaboratory.presentation.base.state.SideEffect
import com.angdroid.minoslaboratory.presentation.base.state.ViewState

abstract class BaseMviActivity<VB : ViewDataBinding, S : ViewState, E : EventState, SE : SideEffect, VM : BaseMviViewModel<S, E, SE>>(@LayoutRes private val layoutResId: Int) :
    BindingActivity<VB>(layoutResId) {
    /**
     * 2개 이상 ViewModel 을 사용하게 된다면 Main 이 되는 ViewModel 을 해당 추상 변수로 사용 권장
     */
    abstract val ownViewModel: VM
}