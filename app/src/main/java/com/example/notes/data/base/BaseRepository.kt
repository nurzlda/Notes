package com.example.notes.data.base

import android.view.textclassifier.ConversationActions
import com.example.notes.data.mappers.toEntity
import com.example.notes.units.ResultStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T) = flow {
        emit(ResultStatus.Loading())
        try {
            val data = request()
            emit(ResultStatus.Success(data))
        }
        catch (e : IOException){
            emit(ResultStatus.Error(e.message ?: "Unknown Error"))
        }
    }.flowOn(Dispatchers.IO)
}