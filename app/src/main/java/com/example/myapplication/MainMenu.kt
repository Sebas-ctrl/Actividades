package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.os.Bundle

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val salir = findViewById<Button>(R.id.btnSalir)
        val operaciones = findViewById<Button>(R.id.btnOperaciones)
        val areas = findViewById<Button>(R.id.btnAreas)
        val perimetros = findViewById<Button>(R.id.btnPerimetro)
        val datos = findViewById<Button>(R.id.btnDatosPersonales)
        val almacenar = findViewById<Button>(R.id.btnAlmacenar)
        val agenda = findViewById<Button>(R.id.btnAgenda)
        salir.setOnClickListener {
            finish()
        }

        operaciones.setOnClickListener {
            val intent = Intent(this, MainOperaciones::class.java)
            startActivity(intent)
        }

        areas.setOnClickListener {
            val intent = Intent(this, MainAreas::class.java)
            startActivity(intent)
        }

        perimetros.setOnClickListener {
            val intent = Intent(this, MainPerimetros::class.java)
            startActivity(intent)
        }

        datos.setOnClickListener {
            val intent = Intent(this, datosPersonales::class.java)
            startActivity(intent)
        }

        almacenar.setOnClickListener {
            val intent = Intent(this, almacenarDatos::class.java)
            startActivity(intent)
        }

        agenda.setOnClickListener {
            val intent = Intent(this, Agenda::class.java)
            startActivity(intent)
        }
    }
}