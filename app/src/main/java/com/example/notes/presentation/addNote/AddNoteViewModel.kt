package com.example.notes.presentation.addNote

import com.example.notes.data.base.BaseViewModel
import com.example.notes.domain.model.Note
import com.example.notes.domain.usecase.CreateNoteUseCase
import com.example.notes.domain.usecase.EditNoteUseCase
import com.example.notes.presentation.notes.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase
) : BaseViewModel() {

    private val _createNotesState = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val createNoteState = _createNotesState.asStateFlow()
    private val _editNotesState = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val editNoteState = _editNotesState.asStateFlow()

    fun createNote(title: String, description: String) {
        if (title.isNotEmpty() && description.isNotBlank()) {
            createNoteUseCase(
                Note(
                    title = title,
                    description = description,
                    createAt = System.currentTimeMillis()

                )
            ).collectFlow(_createNotesState)

        } else {
            _createNotesState.value = UiState.Error("Title is Empty")
        }

    }


    fun editNote(note: Note) {
        if (note.title.isNotEmpty() && note.description.isNotBlank()) {
            editNoteUseCase(
               note
            ).collectFlow(_editNotesState)

        } else {
            _editNotesState.value = UiState.Error("Title is Empty")
        }

    }


}