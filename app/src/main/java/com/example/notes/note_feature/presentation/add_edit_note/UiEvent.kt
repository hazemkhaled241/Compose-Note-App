package com.example.notes.note_feature.presentation.add_edit_note

sealed class UiEvent{
    data class ShowSnackbar(val message: String): UiEvent()
    object SaveNote: UiEvent()
}
