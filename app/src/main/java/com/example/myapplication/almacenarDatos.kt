package com.example.myapplication

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

class almacenarDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_almacenar_datos)

        val txtDatos = findViewById<TextView>(R.id.txtDatos)

        // Botones
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val ver = findViewById<Button>(R.id.btnVerRegistro)
        val salvar = findViewById<Button>(R.id.btnSalvar)
        val abrir = findViewById<Button>(R.id.btnAbrir)
        //

        val nombre = findViewById<EditText>(R.id.txtNombre)
        val correo = findViewById<EditText>(R.id.correo)
        val edad=19
        val altura = 1.6f
        var estatus = true

        val preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE)

        btnGuardar.setOnClickListener {
            val editor = preferencias.edit()
            editor.putString("nombre", nombre.text.toString())
            editor.putString("correo", correo.text.toString())
            editor.putString("edad", edad.toString())
            editor.putString("altura", altura.toString())
            editor.putString("estatus", estatus.toString())
            editor.commit()

            Toast.makeText(this, "¡Datos almacenados correctamente!", Toast.LENGTH_LONG).show()

            txtDatos.text = "Nombre: ${nombre.text.toString()} \nCorreo: ${correo.text.toString()} \nEdad: ${edad.toString()}" +
                      "\nAltura: ${altura.toString()} \nEstatus: ${estatus.toString()}"
        }

        ver.setOnClickListener {
            val informacion = preferencias.getString("", nombre.text.toString())
            if(informacion!=null){
                if(informacion.isEmpty()){
                    Toast.makeText(this, "No existe el registro", Toast.LENGTH_LONG).show()
                }else{
                    txtDatos.text = informacion
                }
            }else{
                Toast.makeText(this, "El campo está en blanco", Toast.LENGTH_LONG).show()
            }
        }

        // Salvar txt
        if(fileList().contains("contactos.txt")){
            try{
                val archivo = InputStreamReader(openFileInput("contacto.txt"))

            }catch(e:IOException){

            }
        }

        salvar.setOnClickListener{
            try{
                val archivo = OutputStreamWriter(openFileOutput("contacto.txt", Activity.MODE_PRIVATE))
                archivo.write(txtDatos.text.toString())
                archivo.flush()
                archivo.close()
            }catch (e:IOException){
            }
            Toast.makeText(this, "El archivo fue almacenado", Toast.LENGTH_LONG).show()
        }

        abrir.setOnClickListener {
            val archivo = InputStreamReader(openFileInput("contacto.txt"))
            val br = BufferedReader(archivo)
            var linea = br.readLine()
            val todo = StringBuilder()
            while (linea!=null){
                todo.append(linea+"\n")
                linea=br.readLine()
            }
            br.close()
            archivo.close()
            txtDatos.text = todo
        }
    }
}