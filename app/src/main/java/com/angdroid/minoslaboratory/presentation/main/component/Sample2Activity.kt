package com.angdroid.minoslaboratory.presentation.main.component

import android.content.Intent
import android.os.Bundle
import com.angdroid.minoslaboratory.R
import com.angdroid.minoslaboratory.databinding.ActivitySample2Binding
import com.angdroid.minoslaboratory.presentation.base.component.LifecycleCallbackActivity

class Sample2Activity : LifecycleCallbackActivity<ActivitySample2Binding>(R.layout.activity_sample2) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnSample2.setOnClickListener {
            startActivity(Intent(this, Sample1Activity::class.java))
        }
    }
}