package com.angdroid.minoslaboratory.presentation.main.component

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.angdroid.minoslaboratory.R
import com.angdroid.minoslaboratory.databinding.FragmentSample2Binding
import com.angdroid.minoslaboratory.presentation.base.component.LifecycleCallbackFragment
import com.angdroid.minoslaboratory.presentation.base.state.EventState
import com.angdroid.minoslaboratory.presentation.main.vm.SampleViewModel
import com.angdroid.minoslaboratory.presentation.util.collectFlow

class SampleFragment2 : LifecycleCallbackFragment<FragmentSample2Binding>(R.layout.fragment_sample2) {
    private val sampleViewModel : SampleViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sampleFm2ViewModel = sampleViewModel

        collectFlow(sampleViewModel.event){ eventState ->
            Log.e("LMH", "Collect Event Sample 2")
            Toast.makeText(requireContext(), "Sample 1", Toast.LENGTH_SHORT).show()
        }
        binding.btnSendEvent2.setOnClickListener {
            sampleViewModel.sendEvent(object : EventState{})
        }
    }
}