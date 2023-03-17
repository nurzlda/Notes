package com.example.notes.presentation.notes


import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.notes.R
import com.example.notes.data.base.BaseFragment
import com.example.notes.databinding.FragmentNotesBinding
import com.example.notes.domain.model.Note
import com.example.notes.extension.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment :
    BaseFragment<NotesViewModel, FragmentNotesBinding>(FragmentNotesBinding::inflate) {
    private val adapter: NotesAdapter by lazy {
        NotesAdapter(
            this::onItemClick,
            this::onItemLongClick
        )
    }
    override val vm: NotesViewModel by viewModels()

    private fun onItemClick(note: Note) {
        val bundle = bundleOf(ARG_ADD_EDIT to note)
        findNavController().navigate(R.id.action_notesFragment_to_addNotesFragment, bundle)
    }

    private fun onItemLongClick(note: Note) {
        vm.deleteNote(note)
    }


    override fun initialize() {
        binding.rvNotes.adapter = adapter
        vm.getAllNotes()
    }

    override fun listeners() {
        binding.btnFab.setOnClickListener {
            findNavController().navigate(R.id.action_notesFragment_to_addNotesFragment)
        }
    }

    override fun setUpRequest() {
        vm.getAllNoteState.collectState(
            onLoading = {
                binding.progressCircular.isVisible = true
            },

            onError = {
                binding.progressCircular.isVisible = false
                showToast(it)
            },

            onSuccess = {
                binding.progressCircular.isVisible = false
                adapter.updateList(it)
            })

        vm.deleteNoteState.collectState(
            onLoading = {
                binding.progressCircular.isVisible = true
            },
            onError = {
                binding.progressCircular.isVisible = false
                showToast(it)

            },
            onSuccess = {
                binding.progressCircular.isVisible = false
                showToast(R.string.deleted)
                adapter.delete()
            })
    }


    companion object {
        const val ARG_ADD_EDIT = "edit note"
    }


}