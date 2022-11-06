package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isVisible
import kotlin.math.pow

class MainAreas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_areas)

        val input1 = findViewById<EditText>(R.id.numInput1)
        val input2 = findViewById<EditText>(R.id.numInput2)

        val rb1 = findViewById<RadioButton>(R.id.rb1)
        val rb2 = findViewById<RadioButton>(R.id.rb2)
        val rb3 = findViewById<RadioButton>(R.id.rb3)
        val rb4 = findViewById<RadioButton>(R.id.rb4)

        val btnReturn = findViewById<ImageButton>(R.id.btnRegresar)
        val btnCalculate = findViewById<Button>(R.id.btnCalcular)

        var radioSelected = ""
        val result = findViewById<TextView>(R.id.numResultado)
        var input2IsActivated = false

        rb1.setOnClickListener {
            input2.isVisible = false
            input1.hint = "Ingrese el lado del cuadrado"
            radioSelected = "cuadrado"
        }
        rb2.setOnClickListener {
            input1.isVisible = true
            input2.isVisible = true
            input1.hint = "Ingrese la base del rectángulo"
            input2.hint = "Ingrese la altura del rectángulo"
            radioSelected = "rectangulo"
            input2IsActivated = true
        }
        rb3.setOnClickListener {
            input1.isVisible = true
            input2.isVisible = false
            input1.hint = "Ingrese el radio del círculo"
            radioSelected = "circulo"
        }
        rb4.setOnClickListener {
            input1.isVisible = true
            input2.isVisible = true
            input1.hint = "Ingrese la base del triángulo"
            input2.hint = "Ingrese la altura del triángulo"
            radioSelected = "triangulo"
            input2IsActivated = true
        }


        btnCalculate.setOnClickListener {
            val val1 = input1.text.toString().toDouble()

            var total = ""
            when ( radioSelected ){
                "cuadrado" -> {
                    total = val1.pow(2).toString()
                    result.text = total
                }
                "rectangulo" -> {
                    if (input2IsActivated) {
                        val val2 = input2.text.toString().toDouble()
                        total = (val1 * val2).toString()
                        result.text = total
                    }
                }
                "circulo" -> {
                    total = (3.1416 * val1.pow(2)).toString()
                    result.text = total
                }
                "triangulo" -> {
                    if (input2IsActivated) {
                        val val2 = input2.text.toString().toDouble()
                        total = (val1 * val2 / 2).toString()
                        result.text = total
                    }
                }
            }
        }

        btnReturn.setOnClickListener {
            finish()
        }
    }
}
