package com.angdroid.minoslaboratory.presentation.base.component

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.angdroid.minoslaboratory.presentation.base.state.EventState
import com.angdroid.minoslaboratory.presentation.base.state.SideEffect
import com.angdroid.minoslaboratory.presentation.base.state.ViewState

abstract class BaseActivity<VB : ViewDataBinding, S : ViewState, E : EventState, SE : SideEffect, VM : BaseViewModel<S, E, SE>>(@LayoutRes private val layoutResId: Int) :
    BindingActivity<VB>(layoutResId) {
    abstract val viewModel: VM
}