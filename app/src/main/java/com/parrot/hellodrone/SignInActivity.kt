package com.parrot.hellodrone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {

    lateinit var emailSigin_input: EditText
    lateinit var passwordSigin_input: EditText
    lateinit var signinbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        emailSigin_input = findViewById(R.id.emailSigin_input)
        passwordSigin_input = findViewById(R.id.passwordSigin_input)
        signinbutton = findViewById(R.id.signinbutton)

        signinbutton.setOnClickListener {
            var email = emailSigin_input.text.toString()
            var password = passwordSigin_input.text.toString()

            val storedEmail = "user@example.com"
            val storedPassword = "password123"

            if (email.isNotEmpty() && password.isNotEmpty()) {
                if (email == storedEmail && password == storedPassword) {
                    // Successful Sign In
                    Toast.makeText(this, "Successfully signed in as $email", Toast.LENGTH_SHORT).show()

                    // Redirect to MainActivity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Close SignInActivity
                } else {
                    Toast.makeText(this, "Invalid email or password. Please try again.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}