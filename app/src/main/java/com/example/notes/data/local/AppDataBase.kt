package com.example.notes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notes.data.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun noteDao():NoteDao
}