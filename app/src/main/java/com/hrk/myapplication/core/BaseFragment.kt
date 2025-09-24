package com.hrk.myapplication.core

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(
    layoutId: Int,
    private val bindingInflater: (View) -> VB
) : Fragment(layoutId) {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = bindingInflater(view)
        onViewBound()
    }

    abstract fun onViewBound()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
