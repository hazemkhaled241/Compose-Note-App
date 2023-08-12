package com.example.notes.di
import android.content.Context
import com.example.notes.note_feature.data.local.data_source.NoteDao
import com.example.notes.note_feature.data.local.data_source.NoteDataBase
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
}