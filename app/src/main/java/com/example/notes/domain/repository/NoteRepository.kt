package com.example.notes.domain.repository

import com.example.notes.domain.model.Note

interface NoteRepository {
    fun createNote(note: Note)

    fun getAllNotes() : List<Note>

    fun editNote(note: Note)

    fun deleteNote(note: Note)
}