package com.example.notes.note_feature.data.local.data_source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes.note_feature.domain.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDataBase:RoomDatabase() {
    abstract fun noteDao():NoteDao
    companion object{
        @Volatile

        private var INSTANCE: NoteDataBase?=null
        fun getDataBase(context: Context): NoteDataBase {
            val tempInstance= INSTANCE
            if(tempInstance!=null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDataBase::class.java,
                    "notes"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}