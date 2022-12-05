package com.hemonugi.random_character_for_slay_the_spire

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = this.findViewById<ImageView>(R.id.imageView)
        val listCharacters = listOf(
            R.drawable.ironclad,
            R.drawable.silent,
            R.drawable.defect,
            R.drawable.watcher,
        )

        imageView.setImageResource(listCharacters.random())
    }
}