package com.example.seminario3di

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView

class Ejercicio3 : AppCompatActivity() {
    var ct : CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        var semaforo = findViewById<ImageView>(R.id.semaforo)

        ct = object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                when {
                    millisUntilFinished < 2000L -> {
                        semaforo.setImageResource(R.drawable.rojo)
                    }
                    millisUntilFinished < 3000L -> {
                        semaforo.setImageResource(R.drawable.naranja)
                    }
                    else -> {
                        semaforo.setImageResource(R.drawable.verde)
                    }
                }

            }

            override fun onFinish() {
                this.start()
            }
        }
        ct!!.start()
    }

    override fun onBackPressed() {
        ct!!.cancel()
        super.onBackPressed()
    }
}