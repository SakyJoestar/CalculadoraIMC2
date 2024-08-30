package com.example.calculadoraimc2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoraimc2.databinding.ActivityMainBinding
import java.util.Locale
import kotlin.math.pow

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

            val pesoTxt= binding.editTextPeso.text.toString()
            val estaturaTxt= binding.editTextEstatura.text.toString()
            if(pesoTxt.isEmpty()|| estaturaTxt.isEmpty())
            {
                binding.textViewResultadoMostrar.text = getString(R.string.salidaErrorCampos)            }
            else{

                val peso = pesoTxt.toFloat()
                val estatura = estaturaTxt.toFloat()
                calcularIMC(peso, estatura)
            }

        }
    }
    private fun calcularIMC(peso: Float, estatura: Float){
        val imc = peso/(estatura.pow(2))

        val resultado = when {
            imc < 18.5 -> "Bajo peso"
            imc in 18.5..24.9 -> "Peso normal"
            imc in 25.0..29.9 -> "Sobrepeso"
            else -> "obesidad"
        }

        val imcRedondeado = String.format(Locale.US,"%.2f", imc)
        val finaltext= "$imcRedondeado\n$resultado"
        binding.textViewResultadoMostrar.text = finaltext
    }
}