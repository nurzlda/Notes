package com.example.notes.extension

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(msg: String) {
    Toast.makeText(this.requireContext(), msg, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(msg: Int) {
    Toast.makeText(this.requireContext(), msg, Toast.LENGTH_SHORT).show()
}

