package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.*
import android.widget.EditText
import java.security.SecureRandom


class MainActivity : AppCompatActivity() {

    private lateinit var passwordTextView: TextView
    private lateinit var passwordLengthEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        passwordTextView = findViewById(R.id.passwordTextView)
        passwordLengthEditText = findViewById(R.id.passwordLengthEditText)
    }

    public fun generatePassword(view: View) {
        val passwordLength = passwordLengthEditText.text.toString().toIntOrNull() ?: 12

        val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+-=[]{}|;':\",./<>?"
        val secureRandom = SecureRandom()
        val sb = StringBuilder(passwordLength)
        for (i in 0 until passwordLength) {
            val randomIndex = secureRandom.nextInt(characters.length)
            sb.append(characters[randomIndex])
        }

        val passwordTextView = findViewById<TextView>(R.id.passwordTextView)
        passwordTextView.text = sb.toString()
    }
}