package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import android.os.Bundle

class datosPersonales : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_personales)

        val nombre = findViewById<EditText>(R.id.txtNombre)
        val direccion = findViewById<EditText>(R.id.txtDireccion)
        val telefono = findViewById<EditText>(R.id.numTelefono)
        val correo = findViewById<EditText>(R.id.correo)
        val fechaNacimiento = findViewById<EditText>(R.id.fechaNacimiento)

        val masculino = findViewById<RadioButton>(R.id.rbMasculino)
        val femenino = findViewById<RadioButton>(R.id.rbFemenino)

        val enviar = findViewById<Button>(R.id.btnEnviar)
        val regresar = findViewById<Button>(R.id.btnRegresar)


        enviar.setOnClickListener {
            val intent: Intent = Intent(this, mostrarDatos::class.java)
            intent.putExtra("nombre", nombre.text.toString())
            intent.putExtra("direccion", direccion.text.toString())
            intent.putExtra("telefono", telefono.text.toString())
            intent.putExtra("correo", correo.text.toString())
            intent.putExtra("fechaNacimiento", fechaNacimiento.text.toString())
            intent.putExtra("genero",
                if(femenino.isChecked){
                    femenino.text.toString()
                }else {
                    masculino.text.toString()
                }
            )
            startActivity(intent)
        }

        regresar.setOnClickListener {
            finish()
        }
    }
}