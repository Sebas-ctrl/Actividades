package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainOperaciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_operaciones)

        val rb1 = findViewById<RadioButton>(R.id.rbSumar)
        val rb2 = findViewById<RadioButton>(R.id.rbRestar)
        val rb3 = findViewById<RadioButton>(R.id.rbMultiplicar)
        val rb4 = findViewById<RadioButton>(R.id.rbDividir)
        val numero1 = findViewById<EditText>(R.id.txtNumber1)
        val numero2 = findViewById<EditText>(R.id.txtNumber2)
        val resultado = findViewById<TextView>(R.id.txtResultado)
        val btnRegresar = findViewById<ImageButton>(R.id.btnRegresar)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            if (rb1.isChecked) {
                resultado.text = "Resultado: " + (numero1.text.toString().toInt() + numero2.text.toString().toInt())
            }
            if (rb2.isChecked) {
                resultado.text = "Resultado: " + (numero1.text.toString().toInt() - numero2.text.toString().toInt())
            }
            if (rb3.isChecked) {
                resultado.text = "Resultado: " + (numero1.text.toString().toInt() * numero2.text.toString().toInt())
            }
            if (rb4.isChecked) {
                resultado.text = "Resultado: " + (numero1.text.toString().toInt() / numero2.text.toString().toInt())
            }
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}