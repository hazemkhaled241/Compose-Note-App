package com.example.notes.note_feature.domain.utils

sealed class OrderType{
    object Ascending:OrderType()
    object Descending:OrderType()
}
