package com.example.notes.presentation.addNotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notes.R
import com.example.notes.databinding.FragmentAddNotesBinding

class AddNotesFragment : Fragment(R.layout.fragment_add_notes) {

    private lateinit var binding: FragmentAddNotesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddNotesBinding.bind(view)
    }

}