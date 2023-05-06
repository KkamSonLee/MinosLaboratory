package com.angdroid.minoslaboratory.presentation.base.component

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

abstract class LifecycleCallbackFragment<VB : ViewDataBinding>(@LayoutRes private val layoutResId: Int) : BindingFragment<VB>(layoutResId) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        Log.e("LMH", "fragment onCreateView: ${this::class.java.simpleName}")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("LMH", "fragment onViewCreated: ${this::class.java.simpleName}")
    }

    override fun onResume() {
        super.onResume()
        Log.e("LMH", "fragment onResume: ${this::class.java.simpleName}")
    }

    override fun onPause() {
        super.onPause()
        Log.e("LMH", "fragment onPause: ${this::class.java.simpleName}")
    }

    override fun onStop() {
        super.onStop()
        Log.e("LMH", "fragment onStop: ${this::class.java.simpleName}")
    }

    override fun onStart() {
        super.onStart()
        Log.e("LMH", "fragment onStart: ${this::class.java.simpleName}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("LMH", "fragment onDestroy: ${this::class.java.simpleName}")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.e("LMH", "fragment onViewStateRestored: ${this::class.java.simpleName}")
    }

}