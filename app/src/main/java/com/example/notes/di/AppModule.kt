package com.example.notes.di
import android.content.Context
import com.example.notes.note_feature.data.local.data_source.NoteDao
import com.example.notes.note_feature.data.local.data_source.NoteDataBase
import com.example.notes.note_feature.domain.repository.NoteRepository
import com.example.notes.note_feature.domain.use_case.DeleteNoteUseCase
import com.example.notes.note_feature.domain.use_case.GetNoteByIdUseCase
import com.example.notes.note_feature.domain.use_case.GetNotesUseCase
import com.example.notes.note_feature.domain.use_case.InsertNoteUseCase
import com.example.notes.note_feature.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideDao(@ApplicationContext context: Context): NoteDao {
        return NoteDataBase.getDataBase(context).noteDao()
    }
    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNoteByIdUseCase = GetNoteByIdUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
            insertNoteUseCase = InsertNoteUseCase(repository),
            getAllNoteUseCase = GetNotesUseCase(repository)
        )
    }

}