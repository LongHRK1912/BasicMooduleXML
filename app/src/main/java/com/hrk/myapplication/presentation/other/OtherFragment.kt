package com.hrk.myapplication.presentation.other

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.hrk.myapplication.R
import com.hrk.myapplication.core.BaseFragment
import com.hrk.myapplication.databinding.FragmentOtherBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OtherFragment : BaseFragment<FragmentOtherBinding>(
    layoutId = R.layout.fragment_other,
    bindingInflater = FragmentOtherBinding::bind
) {
    private val viewModel: OtherViewModel by viewModels()
    override fun onViewBound() {
        binding.btnGoHome.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnGoSettings.setOnClickListener {
            findNavController().navigate(R.id.settingsFragment)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.otherText.collect { msg ->
                    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}