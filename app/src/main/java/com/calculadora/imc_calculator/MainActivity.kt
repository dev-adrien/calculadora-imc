package com.calculadora.imc_calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity

import kotlin.math.pow // importei pra usar potenciação

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val etPeso = findViewById<EditText>(R.id.etPeso)
        val etAltura = findViewById<EditText>(R.id.etAltura)

        val btnCalcular = findViewById<Button>(R.id.btnCalcularImc)

        val tvResult = findViewById<TextView>(R.id.tvResultadoImc)

        val ivImg = findViewById<ImageView>(R.id.imgStatusImc)

        btnCalcular.setOnClickListener {
            try {

            val peso = etPeso.text.toString().toFloat()
            val altura = etAltura.text.toString().toFloat()

            var result = calculoImc(peso, altura)

            tvResult.text = "Resultado: $result"

            if (result < 18.5) {
                tvResult.text = "Você está abaixo do peso! \nIMC: $result"
                ivImg.setImageResource(R.drawable.abaixo_do_peso)
            } else if (result < 25){
                tvResult.text = "Você no peso ideal! \nIMC: $result"
                ivImg.setImageResource(R.drawable.peso_normal)
            } else if (result < 30){
                tvResult.text = "Você tem sobrepeso! \nIMC: $result"
                ivImg.setImageResource(R.drawable.sobrepeso)
            } else if (result < 35){
                tvResult.text = "Você tem Obesidade Grau I! \nIMC: $result"
                ivImg.setImageResource(R.drawable.obesidade_i)
            } else if (result < 40){
                tvResult.text = "Você tem Obesidade Grau II! \nIMC: $result"
                ivImg.setImageResource(R.drawable.obesidade_ii)
            } else if (result >= 40){
                tvResult.text = "Você tem Obesidade Grau III! \nIMC: $result"
                ivImg.setImageResource(R.drawable.obesidade_iii)
            }

            } catch (e: NumberFormatException) {
                tvResult.text = "Por favor, insira números válidos."
            }
        }
    }

    private fun calculoImc(peso: Float, altura: Float): Float {
        return peso/(altura.pow(2))
    }


}