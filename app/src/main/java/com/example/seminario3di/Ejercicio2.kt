package com.example.seminario3di

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import com.example.seminario3di.databinding.ActivityEjercicio2Binding

class Ejercicio2 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEjercicio2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.carta1.setOnClickListener {
            animacionGirar(binding.carta1)
            var ct = object : CountDownTimer(3000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    when{
                        millisUntilFinished > 2700 -> binding.carta1.setImageResource(R.drawable.parte_trasera)
                        millisUntilFinished > 1000 -> binding.carta1.setImageResource(R.drawable.carta1)
                        else -> {
                            binding.carta1.setImageResource(R.drawable.parte_trasera)
                            animacionGirar(binding.carta1)
                        }

                    }
                }
                override fun onFinish() {
                    binding.carta1.setImageResource(R.drawable.parte_trasera)
                }
            }

            ct.start()
        }

        binding.carta2.setOnClickListener {
            animacionGirar(binding.carta2)
            var ct = object : CountDownTimer(1000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    binding.carta2.setImageResource(R.drawable.carta2)
                }
                override fun onFinish() {
                    binding.carta2.setImageResource(R.drawable.parte_trasera)
                }
            }

            ct.start()
        }

        binding.carta3.setOnClickListener {
            animacionGirar(binding.carta3)
            var ct = object : CountDownTimer(1000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    binding.carta3.setImageResource(R.drawable.carta3)
                }
                override fun onFinish() {
                    binding.carta3.setImageResource(R.drawable.parte_trasera)
                }
            }

            ct.start()
        }




    }

    fun animacionGirar(carta: ImageView){
        val animacion =  ObjectAnimator.ofFloat(carta, "rotationY", 0f, 180f)
        animacion.duration = 1000
        animacion.start()
    }


}