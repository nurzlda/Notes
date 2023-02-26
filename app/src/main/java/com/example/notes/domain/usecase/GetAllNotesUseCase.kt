package com.example.notes.domain.usecase

import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NoteRepository

class GetAllNotesUseCase(
    private val noteRepository: NoteRepository
) {
    fun getAllNotes() = noteRepository.getAllNotes()
}