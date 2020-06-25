package com.anderson.calculaimc

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val peso = intent.getStringExtra("KEY_PESO").toDouble()
        val altura = intent.getStringExtra("KEY_ALTURA").toDouble()

        val result_imc = peso / (altura * altura)
        resultIMC.text = result_imc.toString()

        if (result_imc < 18.5){
            resultClassificacao.text = "Abaixo do Peso"
        }else if (result_imc >= 18 && result_imc <= 24){
            resultClassificacao.text = "Peso Ideal"
        }else if (result_imc >= 25 && result_imc <= 29){
            resultClassificacao.text = "Levemente Acima do Peso"
        }else if(result_imc >= 30 && result_imc <= 34){
            resultClassificacao.text= "Obesidade grau 1"
        }else if (result_imc >= 35 && result_imc <= 39){
            resultClassificacao.text = "Obesidade Grau 2"
        }else{
            resultClassificacao.text = "Obesidade 3"
        }

    }

}