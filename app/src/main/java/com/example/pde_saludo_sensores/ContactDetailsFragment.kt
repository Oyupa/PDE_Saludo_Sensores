package com.example.pde_saludo_sensores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class ContactDetailsFragment : Fragment() {

    private lateinit var viewModel: ContactSharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact_details, container, false)
        viewModel = ViewModelProvider(requireActivity())[ContactSharedViewModel::class.java]

        val nameTextView = view.findViewById<TextView>(R.id.text_contact_name)
        val phoneTextView = view.findViewById<TextView>(R.id.text_contact_phone)
        val emailTextView = view.findViewById<TextView>(R.id.text_contact_email)

        // Observar el contacto seleccionado
        viewModel.selectedContact.observe(viewLifecycleOwner) { contact ->
            contact?.let {
                nameTextView.text = it.name
                phoneTextView.text = it.phone
                emailTextView.text = it.email
            }
        }

        return view
    }
}
