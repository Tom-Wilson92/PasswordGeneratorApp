package com.example.myapplication


import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import android.widget.EditText
import android.widget.Toast
import java.security.SecureRandom


class MainActivity : AppCompatActivity() {

    private lateinit var passwordTextView: TextView
    private lateinit var passwordLengthEditText: EditText
    private lateinit var checkBoxUpper: CheckBox
    private lateinit var checkBoxNumbers: CheckBox
    private lateinit var checkBoxSymbols: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        passwordTextView = findViewById(R.id.passwordTextView)
        passwordLengthEditText = findViewById(R.id.passwordLengthEditText)

        checkBoxUpper = findViewById<CheckBox>(R.id.checkBoxUpper)
        checkBoxNumbers = findViewById<CheckBox>(R.id.checkBoxNumbers)
        checkBoxSymbols = findViewById<CheckBox>(R.id.checkBoxSymbols)
    }

    fun generatePassword(view: View) {
        val passwordLength = passwordLengthEditText.text.toString().toIntOrNull() ?: 12
        if (passwordLength > 32) {
            passwordLengthEditText.error = "Password length must be 32 characters or less"
            return
        }

        val characters = StringBuilder()

        // Include lowercase letters by default
        characters.append("abcdefghijklmnopqrstuvwxyz")

        // Include uppercase letters if the checkbox is checked
        if (checkBoxUpper.isChecked) {
            characters.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
        }

        // Include numbers if the checkbox is checked
        if (checkBoxNumbers.isChecked) {
            characters.append("0123456789")
        }

        // Include symbols if the checkbox is checked
        if (checkBoxSymbols.isChecked) {
            characters.append("!@#$%^&*()_+-=[]{}|;':\",./<>?")
        }

        val secureRandom = SecureRandom()
        val sb = StringBuilder(passwordLength)
        for (i in 0 until passwordLength) {
            val randomIndex = secureRandom.nextInt(characters.length)
            sb.append(characters[randomIndex])
        }

        val passwordTextView = findViewById<TextView>(R.id.passwordTextView)
        passwordTextView.text = sb.toString()
    }

     fun copyToClipboard(view : View) {
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val passwordTextView = findViewById<TextView>(R.id.passwordTextView)

        val password = passwordTextView.text.toString()
        val clip = ClipData.newPlainText("password", password)
        clipboardManager.setPrimaryClip(clip)

        Toast.makeText(this, "Password copied to clipboard", Toast.LENGTH_SHORT).show()
    }
}