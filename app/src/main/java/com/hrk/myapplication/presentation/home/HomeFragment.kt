package com.hrk.myapplication.presentation.home

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.hrk.myapplication.R
import com.hrk.myapplication.core.BaseFragment
import com.hrk.myapplication.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(
    R.layout.fragment_home,
    FragmentHomeBinding::bind
) {
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewBound() {
        binding.btnGoSettings.setOnClickListener {
            findNavController().navigate(R.id.settingsFragment)
        }

        binding.btnGoOther.setOnClickListener {
            findNavController().navigate(R.id.otherFragment)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.message.collect { msg ->
                    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}