package com.example.notes.domain.usecase


import android.provider.ContactsContract
import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NoteRepository
import com.example.notes.units.ResultStatus
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetAllNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    operator fun invoke() : Flow<ResultStatus<List<Note>>> = noteRepository.getAllNotes()

}