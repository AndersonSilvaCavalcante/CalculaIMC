package com.anderson.calculaimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var altura_result = 0.0
        var peso_result = 0.0

        val pesoSeekBar: SeekBar
        pesoSeekBar = findViewById(R.id.pesoValue)
        pesoSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                peso_result = progress.toDouble()/10
                pesoResult.text = peso_result.toString() + "KG"

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })

        val alturaSeekBar: SeekBar
        alturaSeekBar = findViewById(R.id.alturaValue)
        alturaSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                altura_result = progress.toDouble()/100
                alturaResult.text = altura_result.toString() + "m"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        btnCalcular.setOnClickListener {
            if (peso_result >0 && altura_result >0) {
                val mIntent = Intent(this, ResultActivity::class.java)
                mIntent.putExtra("KEY_PESO", peso_result.toString())
                mIntent.putExtra("KEY_ALTURA", altura_result.toString())
                startActivity(mIntent)
            }else{
                Toast.makeText(applicationContext, "Escolha valores válidos em altura e peso!", Toast.LENGTH_LONG).show()
            }
        }

    }
}