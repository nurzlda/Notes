package com.example.notes.data.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.presentation.notes.UiState
import com.example.notes.units.ResultStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T> Flow<ResultStatus<T>>.collectFlow(state : MutableStateFlow<UiState<T>>){
        viewModelScope.launch {
            this@collectFlow.collect{
                when(it){
                    is ResultStatus.Error -> state.value = UiState.Error(it.error)
                    is ResultStatus.Loading -> state.value = UiState.Loading()
                    is ResultStatus.Success -> if (it.data != null)
                        state.value = UiState.Success(it.data)
                }
            }
        }
    }
}