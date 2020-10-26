package com.example.sessionmanagement

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details)

        val result = findViewById<TextView>(R.id.resultView)
        val btnLogOut = findViewById<Button>(R.id.btnLogOut)
        val prf = getSharedPreferences("user_details", MODE_PRIVATE)
        val intent = Intent(this, MainActivity::class.java)

        result.text = "Hello, " + prf.getString("username", null)
        btnLogOut.setOnClickListener {
            val editor = prf.edit()
            editor.clear()
            editor.apply()
            startActivity(intent)
        }
    }
}