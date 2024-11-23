package com.example.pde_saludo_sensores

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PrimaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primary)

        // Iniciar con el Fragmento de Lista de Contactos (ContactListFragment)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ContactListFragment())
                .commit()
        }

        // Configurar botón para añadir contactos
        findViewById<Button>(R.id.btn_add_contact).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ContactAddFragment())
                .addToBackStack(null)
                .commit()
        }
    }
    fun saveContactToPreferences(contactName: String) {
        val sharedPreferences = getSharedPreferences("ContactsWidgetPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // Recuperar contactos existentes y agregar el nuevo
        val contacts = sharedPreferences.getStringSet("contacts", mutableSetOf()) ?: mutableSetOf()
        contacts.add(contactName)

        editor.putStringSet("contacts", contacts)
        editor.apply()

        // Notificar al widget que los datos han cambiado
        val intent = Intent(this, ContactsWidgetProvider::class.java).apply {
            action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
        }
        sendBroadcast(intent)
    }
}
