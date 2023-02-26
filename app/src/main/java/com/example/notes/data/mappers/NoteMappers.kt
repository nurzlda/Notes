package com.example.notes.data.mappers

import com.example.notes.data.model.NoteEntity
import com.example.notes.domain.model.Note

fun Note.toEntity() = NoteEntity(
    id, title, description, createAt
)

fun NoteEntity.toNote() = Note(
    id, title, description, createAt
)