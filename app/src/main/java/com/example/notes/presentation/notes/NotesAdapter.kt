package com.example.notes.presentation.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.databinding.NoteItemBinding
import com.example.notes.domain.model.Note

class NotesAdapter(
    private val onItemClick: (Note) -> Unit,
    private val onItemLongClick: (Note) -> Unit
) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    private var data = mutableListOf<Note>()
    private var noteDelete: Note? = null

    fun delete() {
        if (noteDelete != null) {
            data.remove(noteDelete)
            noteDelete = null
            notifyDataSetChanged()
        }
    }

    fun updateList(notes: List<Note>) {
        data = notes as MutableList<Note>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }


    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class NotesViewHolder(private val binding: NoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {

            binding.tvTitle.text = note.title
            binding.tvDescription.text = note.description
            binding.tvAt.text = note.createAt.toString()

            binding.root.setOnClickListener {
                onItemClick(note)

            }

            binding.root.setOnLongClickListener {
                noteDelete = note
                onItemLongClick(note)
                true
            }

        }

    }
}