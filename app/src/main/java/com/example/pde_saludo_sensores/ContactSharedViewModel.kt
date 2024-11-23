package com.example.pde_saludo_sensores

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactSharedViewModel : ViewModel() {

    // Lista de contactos (vinculada al Fragmento A)
    private val _contacts = MutableLiveData<MutableList<Contact>>(mutableListOf())
    val contacts: MutableLiveData<MutableList<Contact>> get() = _contacts

    // Contacto seleccionado (vinculado al Fragmento B)
    private val _selectedContact = MutableLiveData<Contact?>()
    val selectedContact: LiveData<Contact?> get() = _selectedContact

    // Métodos para actualizar datos
    fun addContact(contact: Contact) {
        _contacts.value?.add(contact)
        _contacts.value = _contacts.value // Actualizar LiveData
    }

    fun selectContact(contact: Contact) {
        _selectedContact.value = contact
    }
}



