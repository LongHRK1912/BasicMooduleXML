package com.hrk.myapplication.presentation.setting

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor() : ViewModel() {
    private val _settingsText = MutableStateFlow("Settings Loaded via Flow")
    val settingsText: StateFlow<String> = _settingsText.asStateFlow()
}