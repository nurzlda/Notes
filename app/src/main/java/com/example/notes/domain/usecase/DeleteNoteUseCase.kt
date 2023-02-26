package com.example.notes.domain.usecase

import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val noteRepository: NoteRepository
) {
    fun deleteNote(note: Note) = noteRepository.deleteNote(note)
}