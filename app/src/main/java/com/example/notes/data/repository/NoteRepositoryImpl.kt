package com.example.notes.data.repository

import com.example.notes.data.base.BaseRepository
import com.example.notes.data.local.NoteDao
import com.example.notes.data.mappers.toEntity
import com.example.notes.data.mappers.toNote
import com.example.notes.data.model.NoteEntity
import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NoteRepository
import com.example.notes.units.ResultStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
    ) : NoteRepository, BaseRepository() {

    override fun createNote(note: Note) = doRequest {
        noteDao.createNote(note.toEntity())
    }

    override fun getAllNotes()= doRequest {
        noteDao.getAllNotes().map {it.toNote()}
    }

    override fun editNote(note: Note) = doRequest {
        noteDao.editNote(note.toEntity())
    }

    override fun deleteNote(note: Note) = doRequest {
        noteDao.deleteNote(note.toEntity())
    }

}