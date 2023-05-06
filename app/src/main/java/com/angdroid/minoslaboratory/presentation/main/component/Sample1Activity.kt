package com.angdroid.minoslaboratory.presentation.main.component

import android.os.Bundle
import androidx.activity.viewModels
import com.angdroid.minoslaboratory.R
import com.angdroid.minoslaboratory.databinding.ActivitySample1Binding
import com.angdroid.minoslaboratory.presentation.base.component.LifecycleCallbackActivity
import com.angdroid.minoslaboratory.presentation.main.vm.SampleViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Sample1Activity : LifecycleCallbackActivity<ActivitySample1Binding>(R.layout.activity_sample1) {

    private val sampleViewModel: SampleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.sampleAcViewModel = sampleViewModel

        binding.btnAddSample1.setOnClickListener {
            supportFragmentManager.beginTransaction().add(R.id.fc_container, SampleFragment1()).commit()
        }
        binding.btnAddSample2.setOnClickListener {
            supportFragmentManager.beginTransaction().add(R.id.fc_container, SampleFragment2()).commit()
        }
    }
}