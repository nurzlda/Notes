package com.example.notes.units

sealed class ResultStatus<T>(
    val data :T? = null,
    val error :String = "Unknown Error"
){

    class Loading<T>(): ResultStatus<T>()
    class Success<T>( data: T?): ResultStatus<T>(data = data)
    class Error<T>(message : String) : ResultStatus<T>(error = message )

}
