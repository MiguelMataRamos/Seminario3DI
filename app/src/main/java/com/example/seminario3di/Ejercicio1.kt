package com.example.seminario3di

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.util.Objects
import com.bumptech.glide.Glide


class Ejercicio1 : AppCompatActivity() {
    var ct: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)
        var contador = 10

        var pantalla = findViewById<View>(R.id.pantalla)
        var texto = findViewById<TextView>(R.id.contadortxt)

        ct = object: CountDownTimer(contador.toLong()*1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                texto.text = contador.toString()
                contador--
            }

            override fun onFinish() {
                texto.text = ""
                ponergif()
            }
        }.start()
    }

    fun ponergif(){
        var pantalla = findViewById<ImageView>(R.id.pantalla)
        Glide.with(this)
            .asGif()
            .load(R.drawable.tugif)
            .into(pantalla)
    }

    override fun onBackPressed() {
        ct!!.cancel()
        super.onBackPressed()
        finish()

    }

}
