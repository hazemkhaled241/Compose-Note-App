package com.example.notes.note_feature.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.note_feature.domain.model.Note
import com.example.notes.note_feature.domain.use_case.NoteUseCases
import com.example.notes.note_feature.domain.utils.NoteOrder
import com.example.notes.note_feature.domain.utils.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {
    private val _state = mutableStateOf(NoteState())
    val state: State<NoteState> = _state
    private var recentlyDeletedNote: Note? = null
    private var getNotesJob: Job? = null

    init {
        getNote(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteUseCases.deleteNoteUseCase(event.note)
                    recentlyDeletedNote = event.note
                }
            }

            is NotesEvent.Order -> {
                if (state.value.noteOrder::class == event.noteOrder::class &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType
                )
                    return
                else
                    getNote(state.value.noteOrder)
            }

            NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCases.insertNoteUseCase(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }

            NotesEvent.ToggleOrderSection -> {
                _state.value =
                    state.value.copy(isOrderSectionIsViable = !state.value.isOrderSectionIsViable)
            }
        }
    }

    private fun getNote(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = noteUseCases.getAllNoteUseCase(noteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(notes = notes, noteOrder = noteOrder)
            }.launchIn(viewModelScope)
    }
}