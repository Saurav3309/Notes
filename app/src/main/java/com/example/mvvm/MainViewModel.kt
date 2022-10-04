package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repositoryNotes: RepositoryNotes) : ViewModel() {
    fun getNotes(): LiveData<List<Notes>> {
        return repositoryNotes.getNotes()
    }

    fun InsertNotes(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryNotes.insertNotes(notes)
        }
    }
}