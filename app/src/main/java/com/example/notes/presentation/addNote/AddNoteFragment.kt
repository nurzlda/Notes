package com.example.notes.presentation.addNote

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.notes.R
import com.example.notes.data.base.BaseFragment
import com.example.notes.databinding.FragmentAddNotesBinding
import com.example.notes.domain.model.Note
import com.example.notes.extension.showToast
import com.example.notes.presentation.notes.NotesFragment.Companion.ARG_ADD_EDIT
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddNoteFragment :
    BaseFragment<AddNoteViewModel, FragmentAddNotesBinding>(FragmentAddNotesBinding::inflate) {
    override val vm: AddNoteViewModel by viewModels()
    private val note by lazy { arguments?.getSerializable(ARG_ADD_EDIT) as Note? }


    override fun initialize() {
        if (arguments != null) {
            binding.addTitleTxt.setText(note?.title)
            binding.addDescriptionTxt.setText(note?.description)
        }
    }

    override fun listeners() {
        with(binding) {
            addSaveBtn.setOnClickListener {
                val title = binding.addTitleTxt.text.toString()
                val des = binding.addDescriptionTxt.text.toString()
                if (arguments != null) {
                    vm.editNote(
                        note!!.copy(
                            id = note!!.id,
                            title = title,
                            description = des,
                            createAt = note!!.createAt
                        )
                    )
                } else {
                    vm.createNote(
                        addTitleTxt.text.toString(),
                        addDescriptionTxt.text.toString()

                    )

                }

            }
        }
    }


    override fun setUpRequest() {

        vm.editNoteState.collectState(
            onLoading = {
                binding.progressCircular.isVisible = true
            },
            onError = {
                binding.progressCircular.isVisible = false
                showToast(it)
            },
            onSuccess = {
                binding.progressCircular.isVisible = false
                showToast(R.string.updated)
                findNavController().navigateUp()
            }
        )

        vm.createNoteState.collectState(
            onLoading = {
                binding.progressCircular.isVisible = true
            },
            onError = {
                binding.progressCircular.isVisible = false
                showToast(it)
            },
            onSuccess = {
                binding.progressCircular.isVisible = false
                showToast(R.string.created)
                findNavController().navigateUp()
            }
        )


    }

}