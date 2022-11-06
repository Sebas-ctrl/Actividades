package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = findViewById<EditText>(R.id.txtUsuario)
        val pass = findViewById<EditText>(R.id.txtPassword)

        val button = findViewById<Button>(R.id.btnVerificar)

        var intentsFalls = 0
        button.setOnClickListener {
            if(user.text.contentEquals("")){
                Toast.makeText(applicationContext, "Debes completa el campo de usuario", Toast.LENGTH_SHORT).show()
            }else if(pass.text.contentEquals("")){
                Toast.makeText(applicationContext, "Debes completar el campo de contraseña", Toast.LENGTH_SHORT).show()
            }else{
                if(user.text.contentEquals("admin") && pass.text.contentEquals("1234")){
                    intentsFalls = 0
                    Toast.makeText(applicationContext, "Bienvenido a mi sistema", Toast.LENGTH_SHORT).show()
                    val irAlMenu = Intent(this, MainMenu::class.java)
                    startActivity(irAlMenu)
                    user.setText("")
                    pass.setText("")
                }else{
                    user.setText("")
                    pass.setText("")
                    intentsFalls++
                    if(intentsFalls >= 3){
                        Toast.makeText(applicationContext, "¡Se te ha bloqueado la posibilidad de ingresar debido a 3 intentos fallidos!", Toast.LENGTH_LONG).show()
                        user.isEnabled = false
                        pass.isEnabled = false
                    }else{
                        Toast.makeText(applicationContext, "Usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }
}