package com.example.notes.note_feature.presentation.notes

import com.example.notes.note_feature.domain.model.Note
import com.example.notes.note_feature.domain.utils.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
