package com.example.seminario3di

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import androidx.core.animation.doOnEnd
import com.example.seminario3di.databinding.ActivityEjercicio2Binding
import java.util.concurrent.Semaphore

class Ejercicio2 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio2Binding
    private val semaforo1 = Semaphore(1)
    private val semaforo2 = Semaphore(1)
    private val semaforo3 = Semaphore(1)


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEjercicio2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.carta1.setOnClickListener {
            if (semaforo1.tryAcquire()){
                animacionGirar(binding.carta1,R.drawable.carta1)
                var ct = object : CountDownTimer(2400, 1000) {
                    override fun onTick(millisUntilFinished: Long) {

                    }

                    override fun onFinish() {
                        animacionGirarReversa(binding.carta1,R.drawable.parte_trasera)
                        semaforo1.release()
                    }
                }
                ct.start()

            }

        }

        binding.carta2.setOnClickListener {
            if (semaforo2.tryAcquire()){
                animacionGirar(binding.carta2,R.drawable.carta2)
                var ct = object : CountDownTimer(2400, 1000) {
                    override fun onTick(millisUntilFinished: Long) {

                    }
                    override fun onFinish() {
                        animacionGirarReversa(binding.carta2,R.drawable.parte_trasera)
                        semaforo2.release()}
                }

                ct.start()
            }


        }

        binding.carta3.setOnClickListener {
            if (semaforo3.tryAcquire()){
                animacionGirar(binding.carta3,R.drawable.carta3)
                var ct = object : CountDownTimer(2400, 1000) {
                    override fun onTick(millisUntilFinished: Long) {

                    }
                    override fun onFinish() {
                        animacionGirarReversa(binding.carta3,R.drawable.parte_trasera)
                        semaforo3.release()}
                }

                ct.start()
            }

        }

    }

    fun animacionGirar(carta: ImageView, draw: Int){
        val medioGiro = ObjectAnimator.ofFloat(carta, "rotationY", 0f, 90f)
        medioGiro.duration = 400
        medioGiro.start()

        medioGiro.doOnEnd {
            carta.setImageResource(draw) // Aquí es donde cambias la imagen
            val segundoMedioGiro = ObjectAnimator.ofFloat(carta, "rotationY", 90f, 180f)
            segundoMedioGiro.duration = 400
            segundoMedioGiro.start()
        }
    }

    fun animacionGirarReversa(carta: ImageView, imagen: Int){
        val medioGiro = ObjectAnimator.ofFloat(carta, "rotationY", 180f, 90f)
        medioGiro.duration = 300
        medioGiro.start()

        medioGiro.doOnEnd {
            carta.setImageResource(imagen) // Aquí es donde cambias la imagen
            val segundoMedioGiro = ObjectAnimator.ofFloat(carta, "rotationY", 90f, 0f)
            segundoMedioGiro.duration = 300
            segundoMedioGiro.start()
        }
    }


}