package com.example.sessionmanagement

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.txtName)
        val password = findViewById<EditText>(R.id.txtPwd)
        val loginBtn = findViewById<Button>(R.id.btnLogin)
        val pref = getSharedPreferences("user_details", MODE_PRIVATE)
        val intent = Intent(this, DetailsActivity::class.java)

        if (pref.contains("username") && pref.contains("password")) {
            startActivity(intent)
        }

        loginBtn.setOnClickListener {
            val usernameM = username.text.toString()
            val passwordM = password.text.toString()
            if (usernameM == "geek1" && passwordM == "geekpass1") {
                val editor = pref.edit()
                editor.putString("username", usernameM)
                editor.putString("password", passwordM)
                editor.apply()
                Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Credentials are not valid", Toast.LENGTH_SHORT).show()
            }
        }
    }
}