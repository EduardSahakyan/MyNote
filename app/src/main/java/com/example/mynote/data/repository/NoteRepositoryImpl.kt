package com.example.mynote.data.repository

import com.example.mynote.data.entity.Note

class NoteRepositoryImpl: NoteRepository {
    override fun addNote(title: String, text: String, backgroundColor: Int): Note {
        TODO()
    }

    override fun removeNote(id: Int) {
        TODO("Not yet implemented")
    }

    override fun editNote(id:Int): Note {
        TODO("Not yet implemented")
    }
}