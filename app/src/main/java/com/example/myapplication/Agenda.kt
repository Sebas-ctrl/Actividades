package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.File
import java.lang.StringBuilder

class Agenda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda)

        val fecha = findViewById<EditText>(R.id.fecha)
        val hora = findViewById<EditText>(R.id.hora)

        val asuntos = findViewById<Spinner>(R.id.spin)

        var descripcion = findViewById<TextView>(R.id.txtDescripcion)

        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val btnEliminar = findViewById<Button>(R.id.btnEliminar)
        val btnEditar = findViewById<Button>(R.id.btnEditar)

        btnGuardar.setOnClickListener {
            var nombreArchivo = "${fecha.text.toString().replace("/", "-")}${hora.text}"
            try{
                val archivo = OutputStreamWriter(openFileOutput("$nombreArchivo.txt", Activity.MODE_PRIVATE))
                archivo.write(descripcion.text.toString())
                archivo.flush()
                println(archivo)
                archivo.close()
                Toast.makeText(this, "Se ha guardado el archivo correctamente", Toast.LENGTH_SHORT).show()
                fecha.setText("")
                hora.setText("")
                descripcion.text = ""
            }catch (e:IOException){
            }
        }

        btnBuscar.setOnClickListener {
            var nombreArchivo = "${fecha.text.toString().replace("/", "-")}${hora.text}"
            if(fileList().contains("$nombreArchivo.txt")){
                try {
                    val archivo = InputStreamReader(openFileInput("$nombreArchivo.txt"))
                    val br = BufferedReader(archivo)
                    var linea = br.readLine()
                    val todo = StringBuilder()
                    while(linea != null) {
                        todo.append(linea+"\n")
                        linea = br.readLine()
                    }

                    br.close()
                    archivo.close()
                    descripcion.text = todo
                }catch(e:IOException){

                }
            }else{
                Toast.makeText(this, "No existe ningún archivo con ese nombre", Toast.LENGTH_LONG).show()
                descripcion.text = ""
            }
        }

        btnEliminar.setOnClickListener {
            var nombreArchivo = "${fecha.text.toString().replace("/", "-")}${hora.text}"
            val file = File("/data/data/com.example.myapplication/files/$nombreArchivo.txt")
            val result = file.delete()
            if(result){
                Toast.makeText(this, "¡El archivo se ha eliminado con éxito!", Toast.LENGTH_SHORT).show()
                descripcion.text = ""
                fecha.setText("")
                hora.setText("")
            }else{
                Toast.makeText(this, "No se ha encontrado el archivo", Toast.LENGTH_SHORT).show()
                descripcion.text = ""
            }
        }

        btnEditar.setOnClickListener {
            var nombreArchivo = "${fecha.text.toString().replace("/", "-")}${hora.text}"
            try {
                val archivo = OutputStreamWriter(openFileOutput("$nombreArchivo.txt", Activity.MODE_PRIVATE))
                archivo.write(descripcion.text.toString())
                archivo.flush()
                archivo.close()
                Toast.makeText(this, "¡Se han guardado los cambios correctamente!", Toast.LENGTH_SHORT).show()
                descripcion.text = ""
            }catch(e:IOException){
                print(e)
            }
        }
    }
}