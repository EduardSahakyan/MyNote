package com.example.mynote.data.repository

import com.example.mynote.data.entity.Note

interface NoteRepository {

    fun addNote(title:String, text:String, backgroundColor:Int) : Note

    fun removeNote(id:Int)

    fun editNote(id:Int): Note
}