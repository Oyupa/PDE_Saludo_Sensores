package com.example.pde_saludo_sensores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class ContactAddFragment : Fragment() {

    private lateinit var viewModel: ContactSharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact_add, container, false)
        viewModel = ViewModelProvider(requireActivity())[ContactSharedViewModel::class.java]

        val nameEditText = view.findViewById<EditText>(R.id.edit_text_name)
        val phoneEditText = view.findViewById<EditText>(R.id.edit_text_phone)
        val emailEditText = view.findViewById<EditText>(R.id.edit_text_email)
        val addButton = view.findViewById<Button>(R.id.button_add_contact)

        addButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val email = emailEditText.text.toString()

            if (name.isNotBlank() && phone.isNotBlank() && email.isNotBlank()) {
                viewModel.addContact(Contact(name, phone, email))
                (activity as? PrimaryActivity)?.saveContactToPreferences(name)
                requireActivity().supportFragmentManager.popBackStack()
            }
        }

        return view
    }

}
