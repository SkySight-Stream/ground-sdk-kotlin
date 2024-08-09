package com.parrot.hellodrone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SignupActivity : AppCompatActivity() {

    lateinit var username_input: EditText
    lateinit var email_input: EditText
    lateinit var password_input: EditText
    lateinit var signupbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        username_input = findViewById(R.id.username_input)
        email_input = findViewById(R.id.email_input)
        password_input = findViewById(R.id.password_input)
        signupbutton = findViewById(R.id.signupbutton)

        signupbutton.setOnClickListener {
            val username = username_input.text.toString()
            val email = email_input.text.toString()
            val password = password_input.text.toString()

            // Basic input validation
            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                // You may want to add additional checks for email format here
                Toast.makeText(this, "Successfully signed up as $username", Toast.LENGTH_SHORT).show()

                // Optionally: navigate to SignInActivity or MainActivity after a successful signup
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Optionally call finish() to prevent going back to signup
            } else {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }

        // Link to redirect to SignInActivity
        val signinLink: TextView = findViewById(R.id.signin_link)
        signinLink.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish() // Optional: finish SignupActivity
        }
    }
}