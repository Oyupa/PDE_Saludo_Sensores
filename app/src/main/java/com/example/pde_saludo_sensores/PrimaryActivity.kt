package com.example.pde_saludo_sensores

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
}
