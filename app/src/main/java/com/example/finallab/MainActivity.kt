package com.example.finallab

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editTextTime)
        val buttonStart = findViewById<Button>(R.id.buttonStart)

        buttonStart.setOnClickListener {
            val time = editText.text.toString().toIntOrNull() ?: return@setOnClickListener
            val intent = Intent(this, MyService::class.java).apply {
                putExtra("countdown_value", time)
            }
            startService(intent)
        }
    }
}
