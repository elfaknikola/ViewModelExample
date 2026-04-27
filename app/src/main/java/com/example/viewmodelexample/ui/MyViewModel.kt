package com.example.viewmodelexample.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyViewModel : ViewModel(){
    private val _firstState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val firstState: StateFlow<Boolean> = _firstState.asStateFlow()

    var secondState = mutableStateOf(0)
        private set

    fun changeFirstState() {
        _firstState.value = !_firstState.value
    }

    fun changeSecondState() {
        secondState.value += 1
    }
}