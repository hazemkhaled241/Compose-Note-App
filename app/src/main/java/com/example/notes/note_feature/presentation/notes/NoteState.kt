package com.example.notes.note_feature.presentation.notes

import com.example.notes.note_feature.domain.model.Note
import com.example.notes.note_feature.domain.utils.NoteOrder
import com.example.notes.note_feature.domain.utils.OrderType

data class NoteState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionIsViable: Boolean = false
)
