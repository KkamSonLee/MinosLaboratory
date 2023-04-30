package com.angdroid.minoslaboratory.presentation.main.component

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.angdroid.minoslaboratory.R
import com.angdroid.minoslaboratory.databinding.ActivityMainBinding
import com.angdroid.minoslaboratory.presentation.base.component.BaseActivity
import com.angdroid.minoslaboratory.presentation.main.state.MainContract.MainViewState
import com.angdroid.minoslaboratory.presentation.main.state.MainContract.MainSideEffect
import com.angdroid.minoslaboratory.presentation.main.state.MainContract.MainViewModelAction
import com.angdroid.minoslaboratory.presentation.main.vm.MainViewModel
import com.angdroid.minoslaboratory.presentation.util.collectFlow
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewState, MainViewModelAction, MainSideEffect, MainViewModel>(R.layout.activity_main) {
    override val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.mainViewModel = viewModel
        collectEvent()
        clickEvent()
    }

    private fun clickEvent() {
        binding.button.setOnClickListener {
            viewModel.emitEvent(MainViewModelAction.FetchUserData)
        }
        binding.button2.setOnClickListener {
            viewModel.emitDelayEvent(MainViewModelAction.FetchUserData)
        }
    }

    private fun collectEvent() {
        collectFlow(viewModel.effect) { effect ->
            Log.e("LMH", "handle Event, ${viewModel.effect}")
            when (effect) {
                MainSideEffect.ShowToast -> {
                    Toast.makeText(this, "Show!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}