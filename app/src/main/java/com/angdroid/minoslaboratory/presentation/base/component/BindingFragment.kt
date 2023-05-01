package com.angdroid.minoslaboratory.presentation.base.component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BindingFragment<VB : ViewDataBinding>(@LayoutRes private val layoutRes: Int) : Fragment() {
    private var _binding: VB? = null

    /**
     * protected 접근 제한으로 다른 Fragment 에서 Binding 객체 접근 불가, 상속 받은 Activity 만 사용 가능
     */
    protected val binding get() = checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        _binding!!.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}