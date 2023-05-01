package com.angdroid.minoslaboratory.presentation.base.component

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BindingActivity<VB : ViewDataBinding>(@LayoutRes private val layoutResId: Int) : AppCompatActivity() {
    private lateinit var _binding: VB

    /**
     * protected 접근 제한으로 다른 Fragment 에서 Binding 객체 접근 불가, 상속 받은 Activity 만 사용 가능
     */
    protected val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this
    }
}

