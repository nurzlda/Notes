package com.example.notes.presentation.notes

import com.example.notes.data.base.BaseViewModel
import com.example.notes.domain.model.Note
import com.example.notes.domain.usecase.DeleteNoteUseCase
import com.example.notes.domain.usecase.GetAllNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase

) : BaseViewModel() {



    private val _notesState = MutableStateFlow<UiState<List<Note>>>(UiState.Empty())
    val getAllNoteState = _notesState.asStateFlow()
    private val _deleteNoteState =MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val deleteNoteState = _deleteNoteState.asStateFlow()



   fun getAllNotes(){
      getAllNotesUseCase().collectFlow(_notesState)
    }

    fun deleteNote(note: Note){
       deleteNoteUseCase(note).collectFlow(_deleteNoteState)
    }

}