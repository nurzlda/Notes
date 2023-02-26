package com.example.notes.data.repository

import com.example.notes.data.local.NoteDao
import com.example.notes.data.mappers.toEntity
import com.example.notes.data.mappers.toNote
import com.example.notes.data.model.NoteEntity
import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NoteRepository

class NoteRepositoryImpl(
    private val noteDao: NoteDao
    ) : NoteRepository{

    override fun createNote(note: Note) {
       noteDao.createNote(note.toEntity())
    }

    override fun getAllNotes(): List<Note> {
       return noteDao.getAllNotes().map { it.toNote()
       }
    }

    override fun editNote(note: Note) {
       noteDao.editNote(note.toEntity())
    }

    override fun deleteNote(note: Note) {
       noteDao.deleteNote(note.toEntity())
    }

}