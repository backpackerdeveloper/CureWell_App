package com.shubhamtripz.curewell

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)

        firebaseAuth = FirebaseAuth.getInstance()
        val btnSingUp = findViewById<TextView>(R.id.btntSingUp)
        btnSingUp.setOnClickListener {
            singUpUser()
        }

        val btnLogin = findViewById<TextView>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }


    private fun singUpUser() {

        val etEmailAddress = findViewById<EditText>(R.id.etEmailAddress)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<EditText>(com.google.android.material.R.id.textinput_counter)

        val email = etEmailAddress.text.toString()
        val password = etPassword.text.toString()
        val confirmpassword = etConfirmPassword.text.toString()

        if (email.isBlank() || password.isBlank() || confirmpassword.isBlank()) {
            Toast.makeText(this, "Email and password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmpassword) {
            Toast.makeText(this, "Password and confirm password not matched", Toast.LENGTH_SHORT)
                .show()
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    //code
                    Toast.makeText(this, "successfulL", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    Toast.makeText(this, "error creating user", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
