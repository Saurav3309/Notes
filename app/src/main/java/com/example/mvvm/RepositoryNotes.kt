package com.example.mvvm

import androidx.lifecycle.LiveData

class RepositoryNotes(private val notesDao: NotesDao) {
    suspend fun insertNotes(notes: Notes){
        notesDao.insertNote(notes)
    }
      fun getNotes():LiveData<List<Notes>>{
        return notesDao.getNotes()
    }


}