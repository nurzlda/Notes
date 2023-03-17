package com.example.notes.domain.usecase

import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    operator fun invoke(note: Note) = noteRepository.deleteNote(note)
}