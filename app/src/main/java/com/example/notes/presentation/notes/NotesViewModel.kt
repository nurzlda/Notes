package com.example.notes.presentation.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.domain.model.Note
import com.example.notes.domain.usecase.GetAllNotesUseCase
import com.example.notes.units.ResultStatus
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class NotesViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
) : ViewModel() {

    private val _notesState = MutableStateFlow<UiState<List<Note>>>(UiState.Empty())
    val noteState = _notesState.asStateFlow()

    fun getAllNotes(){
       viewModelScope.launch {
           getAllNotesUseCase.getAllNotes().collect{
               when(it){
                   is ResultStatus.Error -> {
                       _notesState.value = UiState.Error(it.error)
                   }
                   is ResultStatus.Loading -> {
                       _notesState.value = UiState.Loading()
                   }
                   is ResultStatus.Success -> {
                       if (it.data != null)
                           _notesState.value = UiState.Success(it.data)
                   }
               }
           }
       }
    }

}