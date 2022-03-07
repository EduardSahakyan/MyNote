package com.example.mynote.domain.usecases

import com.example.mynote.data.repository.NoteRepository

class EditNoteUseCase(private val noteRepository: NoteRepository) {

    operator fun invoke(id:Int){
        noteRepository.editNote(id)
    }
}