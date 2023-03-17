package com.example.notes.domain.repository

import com.example.notes.domain.model.Note
import com.example.notes.units.ResultStatus
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun createNote(note: Note): Flow<ResultStatus<Unit>>

    fun getAllNotes(): Flow<ResultStatus<List<Note>>>

    fun editNote(note: Note): Flow<ResultStatus<Unit>>

    fun deleteNote(note: Note): Flow<ResultStatus<Unit>>
}