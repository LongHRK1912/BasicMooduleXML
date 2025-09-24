package com.hrk.myapplication.presentation.setting

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.hrk.myapplication.R
import com.hrk.myapplication.core.BaseFragment
import com.hrk.myapplication.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SettingsFragment : BaseFragment<FragmentSettingsBinding>(
    layoutId = R.layout.fragment_settings,
    bindingInflater = FragmentSettingsBinding::bind,
) {
    private val viewModel: SettingsViewModel by viewModels()

    override fun onViewBound() {
        binding.btnGoHome.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnGoOther.setOnClickListener {
            findNavController().navigate(R.id.otherFragment)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.settingsText.collect { msg ->
                    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}