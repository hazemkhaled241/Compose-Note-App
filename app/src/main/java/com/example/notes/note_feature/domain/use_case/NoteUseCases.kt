package com.example.notes.note_feature.domain.use_case

data class NoteUseCases(
    val insertNoteUseCase: InsertNoteUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val getAllNoteUseCase: InsertNoteUseCase,
    val getNoteByIdUseCase: GetNoteByIdUseCase
)
