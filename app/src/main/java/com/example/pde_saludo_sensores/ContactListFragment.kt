package com.example.pde_saludo_sensores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactListFragment : Fragment() {

    private lateinit var viewModel: ContactSharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact_list, container, false)
        viewModel = ViewModelProvider(requireActivity())[ContactSharedViewModel::class.java]

        // Configurar RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_contacts)
        val adapter = ContactListAdapter { contact ->
            viewModel.selectContact(contact)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ContactDetailsFragment())
                .addToBackStack(null)
                .commit()
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Observar lista de contactos
        viewModel.contacts.observe(viewLifecycleOwner) { contacts ->
            adapter.submitList(contacts)
        }

        return view
    }
}

