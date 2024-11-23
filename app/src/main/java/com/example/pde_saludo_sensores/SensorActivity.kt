package com.example.pde_saludo_sensores
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SensorActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null
    private var magnetometer: Sensor? = null
    private var lightSensor: Sensor? = null

    private var gravity: FloatArray? = null
    private var geomagnetic: FloatArray? = null

    private lateinit var arrowImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor)

        // Inicializar la vista de la flecha
        arrowImageView = findViewById(R.id.arrow)

        // Inicializar el SensorManager y sensores
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
    }

    override fun onResume() {
        super.onResume()
        // Registrar listeners
        accelerometer?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_UI)
        }
        magnetometer?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_UI)
        }
        lightSensor?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onPause() {
        super.onPause()
        // Desregistrar listeners
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event == null) return

        when (event.sensor.type) {
            Sensor.TYPE_ACCELEROMETER -> {
                gravity = event.values
            }
            Sensor.TYPE_MAGNETIC_FIELD -> {
                geomagnetic = event.values
            }
            Sensor.TYPE_LIGHT -> {
                // Cambiar el color de la flecha según la luminosidad
                val lightLevel = event.values[0]
                val color = when {
                    lightLevel < 500 -> android.graphics.Color.RED // Luz baja
                    lightLevel < 10000 -> android.graphics.Color.YELLOW // Luz media
                    lightLevel < 25000 -> android.graphics.Color.GREEN // Luz media-alta
                    else -> android.graphics.Color.BLUE // Luz alta
                }
                arrowImageView.setColorFilter(color)
            }
        }

        // Calcular la orientación si ambos sensores están disponibles
        if (gravity != null && geomagnetic != null) {
            val R = FloatArray(9)
            val I = FloatArray(9)
            if (SensorManager.getRotationMatrix(R, I, gravity, geomagnetic)) {
                val orientation = FloatArray(3)
                SensorManager.getOrientation(R, orientation)
                val azimuth = Math.toDegrees(orientation[0].toDouble()).toFloat()
                // Rotar la flecha según el azimut
                arrowImageView.rotation = -azimuth
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // No necesitamos manejar cambios en la precisión para este caso
    }
}
