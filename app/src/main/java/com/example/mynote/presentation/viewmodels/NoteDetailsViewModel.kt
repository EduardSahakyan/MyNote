package com.example.mynote.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynote.domain.usecases.AddNoteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteDetailsViewModel: ViewModel() {

    lateinit var addNote: AddNoteUseCase

    fun add(title:String, text:String, backgroundColor:Int){
        viewModelScope.launch(Dispatchers.IO) { addNote(title, text, backgroundColor) }
    }

}