package com.example.pde_saludo_sensores


import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {


    private lateinit var rootLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // Obtener el TextView para el saludo
        val tvGreeting: TextView = findViewById(R.id.tvGreeting)
        // Obtener el botón para ir a la actividad principal
        val btnGoToMainActivity: Button = findViewById(R.id.btnGoToMainActivity)

        val btnGoToSensorActivity: Button = findViewById(R.id.btnGoToSensorActivity)

        // Obtener la hora actual
        val hourOfDay = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY)

        // Establecer el saludo según la hora del día
        val greeting = when {
            hourOfDay in 5..13 -> "¡Buenos días!"
            hourOfDay in 14..22-> "¡Buenas tardes!"
            else -> "¡Buenas noches!"
        }

        // Actualizar el saludo en el TextView
        tvGreeting.text = greeting

        // Configurar el botón para navegar a la actividad principal
        btnGoToMainActivity.setOnClickListener {
            // Navegar a la Actividad Principal (deberás crear esta actividad más adelante)
            val intent = Intent(this, PrimaryActivity::class.java)
            startActivity(intent)
        }
        btnGoToSensorActivity.setOnClickListener {
            // Navegar a la Actividad Principal (deberás crear esta actividad más adelante)
            val intent = Intent(this, SensorActivity::class.java)
            startActivity(intent)
        }
    }
}
