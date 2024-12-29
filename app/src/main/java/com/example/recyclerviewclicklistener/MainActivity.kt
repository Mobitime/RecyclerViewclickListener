package com.example.recyclerviewclicklistener

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnToWardrobe).setOnClickListener {
            startActivity(Intent(this, WardrobeActivity::class.java))
        }
    }
}