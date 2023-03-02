package com.example.notes.data.repository

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
    ) : NoteRepository {

    override fun createNote(note: Note): Flow<ResultStatus<Unit>> = flow {
        emit(ResultStatus.Loading())

        try {
            val data = noteDao.createNote(note.toEntity())
            emit(ResultStatus.Success(data = data))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)


    override fun getAllNotes(): Flow<ResultStatus<List<Note>>> =flow {
            emit(ResultStatus.Loading())

            try {
                val data = noteDao.getAllNotes().map {
                    it.toNote()
                }
                emit(ResultStatus.Success(data = data))
            } catch (e: IOException) {
                emit(ResultStatus.Error(e.message))
            }
        }.flowOn(Dispatchers.IO)



    override fun editNote(note: Note) : Flow<ResultStatus<Unit>>  = flow {
        emit(ResultStatus.Loading())

        try {
            val data = noteDao.editNote(note.toEntity())
            emit(ResultStatus.Success(data = data))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)

    override fun deleteNote(note: Note) : Flow<ResultStatus<Unit>> = flow {
        emit(ResultStatus.Loading())

        try {
            val data = noteDao.deleteNote(note.toEntity())
            emit(ResultStatus.Success(data = data))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)

}