package com.example.notes.note_feature.domain.use_case

import com.example.notes.note_feature.domain.model.Note
import com.example.notes.note_feature.domain.repository.NoteRepository
import com.example.notes.note_feature.domain.utils.InvalidNoteException
import javax.inject.Inject

class InsertNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(note: Note){
        if(note.title.isBlank())
            throw InvalidNoteException("The title of the note can't be empty.")
        if(note.content.isBlank())
            throw InvalidNoteException("The content of the note can't be empty.")

         noteRepository.insertNote(note)
    }
}