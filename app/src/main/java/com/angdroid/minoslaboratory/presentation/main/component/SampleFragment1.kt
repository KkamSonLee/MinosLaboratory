package com.angdroid.minoslaboratory.presentation.main.component

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.angdroid.minoslaboratory.R
import com.angdroid.minoslaboratory.databinding.FragmentSample1Binding
import com.angdroid.minoslaboratory.presentation.base.component.LifecycleCallbackActivity
import com.angdroid.minoslaboratory.presentation.base.component.LifecycleCallbackFragment
import com.angdroid.minoslaboratory.presentation.base.state.EventState
import com.angdroid.minoslaboratory.presentation.main.vm.SampleViewModel
import com.angdroid.minoslaboratory.presentation.util.collectFlow

class SampleFragment1 : LifecycleCallbackFragment<FragmentSample1Binding>(R.layout.fragment_sample1) {

    private val sampleViewModel: SampleViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sampleFm1ViewModel = sampleViewModel

        collectFlow(sampleViewModel.event) { eventState ->
            Log.e("LMH", "Collect Event Sample 1")
            Toast.makeText(requireContext(), "Sample 1", Toast.LENGTH_SHORT).show()
        }

        binding.btnSendEvent1.setOnClickListener {
            sampleViewModel.sendEvent(object : EventState {})
        }
    }
}