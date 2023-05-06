package com.angdroid.minoslaboratory.presentation.base.component

import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

abstract class LifecycleCallbackActivity<VB : ViewDataBinding>(@LayoutRes private val layoutResId: Int) : BindingActivity<VB>(layoutResId) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("LMH", "activity onCreate: ${this::class.java.simpleName}")
    }

    override fun onResume() {
        super.onResume()
        Log.e("LMH", "activity onResume: ${this::class.java.simpleName}")
    }

    override fun onPause() {
        super.onPause()
        Log.e("LMH", "activity onPause: ${this::class.java.simpleName}")
    }

    override fun onStop() {
        super.onStop()
        Log.e("LMH", "activity onStop: ${this::class.java.simpleName}")
    }

    override fun onStart() {
        super.onStart()
        Log.e("LMH", "activity onStart: ${this::class.java.simpleName}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("LMH", "activity onDestroy: ${this::class.java.simpleName}")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("LMH", "activity onReStart: ${this::class.java.simpleName}")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e("LMH", "activity onRestore: ${this::class.java.simpleName}")
    }
}