package com.example.mvvm

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Notes(

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String
)