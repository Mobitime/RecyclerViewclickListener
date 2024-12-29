package com.example.recyclerviewclicklistener

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class EditClothingDialog(private var clothingItem: ClothingItem, private val onUpdate: (ClothingItem) -> Unit) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.activity_edit_clothing_dialog, null)

        val etTitle = view.findViewById<EditText>(R.id.etTitle)
        val etDescription = view.findViewById<EditText>(R.id.etDescription)
        val btnUpdate = view.findViewById<Button>(R.id.btnUpdate)
        val btnCancel = view.findViewById<Button>(R.id.btnCancel)

        etTitle.setText(clothingItem.title)
        etDescription.setText(clothingItem.description)

        btnUpdate.setOnClickListener {
            clothingItem.title = etTitle.text.toString()
            clothingItem.description = etDescription.text.toString()
            onUpdate(clothingItem)
            dismiss()
        }

        btnCancel.setOnClickListener {
            dismiss()
        }

        builder.setView(view)
        return builder.create()
    }
}