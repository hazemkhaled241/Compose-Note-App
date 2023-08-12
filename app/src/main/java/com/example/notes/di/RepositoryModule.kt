package com.example.notes.di

import com.example.notes.note_feature.data.local.data_source.NoteDao
import com.example.notes.note_feature.data.repository.NoteRepositoryImp
import com.example.notes.note_feature.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepositoryImp(noteDao)
    }
}