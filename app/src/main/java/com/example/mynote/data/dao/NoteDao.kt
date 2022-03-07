package com.example.mynote.data.dao

import androidx.room.*
import com.example.mynote.data.entity.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun getNoteList(): List<Note>
    @Insert
    fun insertNote(note: Note)
    @Update
    fun updateNote(note: Note)
    @Delete
    fun deleteNote(note: Note)
}