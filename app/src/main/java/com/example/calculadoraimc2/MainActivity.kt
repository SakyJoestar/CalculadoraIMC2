package com.example.calculadoraimc2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoraimc2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        button()
    }

    private fun button(){
        binding.button.setOnClickListener{

            var pesoTxt= binding.editTextPeso.text.toString()
            var estaturaTxt= binding.editTextEstatura.text.toString()
            if(pesoTxt.isEmpty()|| estaturaTxt.isEmpty())
            {
                binding.textViewResultadoMostrar.text = "Rellene bien los tados"
            }
            else{

                var peso = pesoTxt.toFloat()
                var estatura = estaturaTxt.toFloat()
                calcularIMC(peso, estatura)
            }

        }
    }
    private fun calcularIMC(peso: Float, estatura: Float){
        var imc = peso/(estatura * estatura)

        lateinit var resultado: String

        if(imc < 18.5){
            resultado = "Bajo Peso"
        }
        else if(imc>= 18.5 && imc <=24.9){
            resultado = "Peso normal"
        }
        else if(imc>= 25 && imc <= 29.9){
            resultado = "Sobrepeso"
        }
        else if(imc >= 30){
            resultado = "Obesidad"
        }
        binding.textViewResultadoMostrar.text = resultado
    }
}