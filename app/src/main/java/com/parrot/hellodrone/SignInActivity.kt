package com.parrot.hellodrone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {

    // Declare your UI elements
    lateinit var emailSigin_input: EditText
    lateinit var passwordSigin_input: EditText
    lateinit var signinbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        // Initialize the UI elements
        emailSigin_input = findViewById(R.id.emailSigin_input)
        passwordSigin_input = findViewById(R.id.passwordSigin_input)
        signinbutton = findViewById(R.id.signinbutton)

        // Set onClickListener for the sign-in button
        signinbutton.setOnClickListener {
            // Get user input
            val email = emailSigin_input.text.toString().trim()
            val password = passwordSigin_input.text.toString().trim()

            // Hardcoded credentials (for testing)
            val storedEmail = "user@example.com"
            val storedPassword = "password"

            // Validating user input
            if (email.isNotEmpty() && password.isNotEmpty()) {
                if (email == storedEmail && password == storedPassword) {
                    // Successful Sign In
                    Toast.makeText(this, "Successfully signed in as $email", Toast.LENGTH_SHORT).show()
                    Log.d("SignInActivity", "SignIn Successful: $email")

                    // Redirect to MainActivity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Close SignInActivity
                } else {
                    Toast.makeText(this, "Invalid email or password. Please try again.", Toast.LENGTH_SHORT).show()
                    Log.d("SignInActivity", "SignIn Failed: Invalid credentials")
                }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                Log.d("SignInActivity", "SignIn Failed: Empty fields")
            }
        }
    }
}