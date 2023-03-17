package com.example.notes.domain.model

import java.io.Serializable
import javax.inject.Inject

data class Note(
    val id: Int = DEFAULT_ID,
    val title: String,
    val description: String,
    val createAt: Long
) : Serializable {
    companion object {
        const val DEFAULT_ID = 0
    }
}
