package com.hrk.myapplication.presentation.other

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class OtherViewModel @Inject constructor() : ViewModel() {
    private val _otherText = MutableStateFlow("Other Screen with Flow")
    val otherText: StateFlow<String> = _otherText.asStateFlow()
}