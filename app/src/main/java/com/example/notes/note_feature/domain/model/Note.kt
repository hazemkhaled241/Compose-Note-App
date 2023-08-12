package com.example.notes.note_feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notes.ui.theme.*
@Entity(tableName = "notes")
data class Note(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey
    val id: Int? = null
){
    companion object{
        val noteList = listOf(RedOrange,LightGreen,BabyBlue,RedPink,Violet)
    }
}
