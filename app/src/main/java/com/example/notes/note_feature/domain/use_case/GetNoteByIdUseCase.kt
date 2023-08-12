package com.example.notes.note_feature.domain.use_case

import com.example.notes.note_feature.domain.model.Note
import com.example.notes.note_feature.domain.repository.NoteRepository
import javax.inject.Inject

class GetNoteByIdUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(id:Int): Note?{
       return noteRepository.getNoteById(id)
    }
}