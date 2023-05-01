package com.angdroid.minoslaboratory.presentation.main.component

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.angdroid.minoslaboratory.R
import com.angdroid.minoslaboratory.databinding.ActivityMainBinding
import com.angdroid.minoslaboratory.presentation.base.component.BaseMviActivity
import com.angdroid.minoslaboratory.presentation.main.state.MainContract.MainViewState
import com.angdroid.minoslaboratory.presentation.main.state.MainContract.MainSideEffect
import com.angdroid.minoslaboratory.presentation.main.state.MainContract.MainViewModelAction
import com.angdroid.minoslaboratory.presentation.main.vm.MainMviViewModel
import com.angdroid.minoslaboratory.presentation.util.collectFlow
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainMviActivity : BaseMviActivity<ActivityMainBinding, MainViewState, MainViewModelAction, MainSideEffect, MainMviViewModel>(R.layout.activity_main) {
    override val ownViewModel: MainMviViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.mainViewModel = ownViewModel
        collectEvent()
        clickEvent()
    }

    private fun clickEvent() {
        binding.button.setOnClickListener {
            ownViewModel.emitEvent(MainViewModelAction.FetchUserData)
        }
        binding.button2.setOnClickListener {
            ownViewModel.emitDelayEvent(MainViewModelAction.FetchUserData)
        }
    }

    private fun collectEvent() {
        collectFlow(ownViewModel.effect) { effect ->
            Log.e("LMH", "handle Event, ${ownViewModel.effect}")
            when (effect) {
                MainSideEffect.ShowToast -> {
                    Toast.makeText(this, "Show!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}