package com.example.myapplication

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class mostrarDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_datos)

        val txtDatos = findViewById<TextView>(R.id.txtDatos)
        val salir = findViewById<Button>(R.id.btnSalir)
        val image = findViewById<ImageView>(R.id.imgPerfil)

        val bundle = intent.extras
        val nombre = bundle?.getString("nombre")
        val direccion = bundle?.getString("direccion")
        val telefono = bundle?.getString("telefono")
        val correo = bundle?.getString("correo")
        val fechaNacimiento = bundle?.getString("fechaNacimiento")
        val genero = bundle?.getString("genero")

        if (genero == "Masculino"){
            image.setImageResource(R.mipmap.perfil_masculino)
        }else{
            image.setImageResource(R.mipmap.perfil_femenino)
        }

        txtDatos.text = "Nombre: $nombre \nDirección: $direccion \nTeléfono: $telefono \nCorreo: $correo \nFecha de nacimiento: $fechaNacimiento \nGénero: $genero"

        salir.setOnClickListener {
            finish()
        }
    }
}