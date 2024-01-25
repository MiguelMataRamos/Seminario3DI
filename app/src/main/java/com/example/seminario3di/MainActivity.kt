package com.example.seminario3di

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.seminario3di.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.btn1.setOnClickListener {
            var intent = Intent(this, Ejercicio1::class.java)
            startActivity(intent)
        }

        bind.btn2.setOnClickListener {
            var intent = Intent(this, Ejercicio2::class.java)
            startActivity(intent)
        }

        bind.btn3.setOnClickListener {
            var intent = Intent(this, Ejercicio3::class.java)
            startActivity(intent)
        }
    }
}