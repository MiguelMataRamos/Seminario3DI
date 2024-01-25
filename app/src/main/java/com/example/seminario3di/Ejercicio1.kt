package com.example.seminario3di

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import java.util.Objects

class Ejercicio1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)
        var contador = 10

        var pantalla = findViewById<View>(R.id.pantalla)
        var texto = findViewById<TextView>(R.id.contadortxt)

        var ct = object: CountDownTimer(contador.toLong()*1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                texto.text = contador.toString()
                contador--
            }

            override fun onFinish() {
                texto.text = ""
                pantalla.background = getDrawable(R.drawable.happy)
            }
        }.start()
    }
}