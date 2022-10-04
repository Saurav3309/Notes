package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = NotesDatabase.getDatabase(applicationContext).notesDao()
        var repositoryNotes = RepositoryNotes(dao)
        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(repositoryNotes)
        ).get(MainViewModel::class.java)
        mainViewModel.getNotes().observe(this, {
            binding.textView.text = it.toString()
        })
        binding.btn.setOnClickListener {
            if (binding.input.text!!.isEmpty()) {
                binding.input.error = "empty"
            } else {
                mainViewModel.InsertNotes(Notes(0, binding.input.text.toString()))
                Toast.makeText(this, "done", Toast.LENGTH_SHORT).show()
                binding.input.text = null
            }
        }
    }
}