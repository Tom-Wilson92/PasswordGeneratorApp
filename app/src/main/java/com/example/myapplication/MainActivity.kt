package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*
import android.widget.Button
import android.view.View



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generateButton = findViewById<Button>(R.id.generateButton)
        generateButton.setOnClickListener {
            generatePassword()
        }
    }




fun generatePassword() {
    val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+-=[]{}|;':\",./<>?"
    val length = 12
    val random = Random()
    val sb = StringBuilder(length)
    for (i in 0 until length) {
        sb.append(characters[random.nextInt(characters.length)])
    }
    val passwordTextView = findViewById<View>(android.R.id.content).findViewById<TextView>(R.id.passwordTextView)
    passwordTextView.text = sb.toString()
    }
}