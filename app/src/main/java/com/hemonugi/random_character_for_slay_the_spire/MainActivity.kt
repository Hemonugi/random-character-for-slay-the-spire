package com.hemonugi.random_character_for_slay_the_spire

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var isRolling = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val imageView = this.findViewById<ImageView>(R.id.imageView)
        val listCharacters = listOf(
            R.drawable.ironclad,
            R.drawable.silent,
            R.drawable.defect,
            R.drawable.watcher,
        )

        runRollingCharacters(imageView, listCharacters)

        imageView.setOnClickListener {
            if (!isRolling) {
                runRollingCharacters(imageView, listCharacters)
            }
        }
    }

    private fun runRollingCharacters(imageView: ImageView, listCharacters: List<Int>) {
        val randomIndex = listCharacters.indices.random();

        var i = randomIndex
        val time: Long = 1500
        var speed = 100f

        isRolling = true

        object : CountDownTimer(time, 100) {
            var sinceLastTick = 0f

            override fun onTick(millisUntilFinished: Long) {
                sinceLastTick += 100f
                if (sinceLastTick >= speed) {
                    imageView.setImageResource(listCharacters[i])
                    i = if (i == 3) 0 else i + 1

                    speed = 100f * (time / millisUntilFinished)
                    sinceLastTick = 0f
                }
            }

            override fun onFinish() {
                isRolling = false
            }
        }.start()
    }
}