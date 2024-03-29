package com.example.notes.presentation.notes


sealed class UiState<T> {
    class Loading<T>() : UiState<T>()
    class Success<T> (val data : T?) : UiState<T>()
    class Error<T> (val msg :String) : UiState<T>()
    class Empty<T>  : UiState<T>()

}