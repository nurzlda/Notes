package com.example.notes.data.local

import androidx.room.*
import com.example.notes.data.model.NoteEntity

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<NoteEntity>

    @Update
    fun editNote(noteEntity: NoteEntity)

    @Delete
    fun deleteNote(noteEntity: NoteEntity)
}