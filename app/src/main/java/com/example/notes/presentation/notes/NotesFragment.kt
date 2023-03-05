package com.example.notes.presentation.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import com.example.notes.R
import com.example.notes.databinding.FragmentNotesBinding
import kotlinx.coroutines.launch

class NotesFragment : Fragment(R.layout.fragment_notes) {


    private val viewModel : NotesViewModel by viewModels()
    private lateinit var binding: FragmentNotesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNotesBinding.bind(view)

        listeners()
    }

    private fun listeners() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.noteState.collect{
                    when(it){
                        is UiState.Empty -> {

                        }
                        is UiState.Error -> {

                        }
                        is UiState.Loading -> {

                        }
                        is UiState.Success -> {

                        }
                    }
                }
            }
        }
    }


}