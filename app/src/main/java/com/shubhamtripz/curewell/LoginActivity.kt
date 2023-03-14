package com.shubhamtripz.curewell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth = FirebaseAuth.getInstance()

        val btnLogin = findViewById<TextView>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            login()
        }

        val btntSingUp = findViewById<TextView>(R.id.btntSingUp)

        btntSingUp.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun login(){

        val etEmailAddress = findViewById<EditText>(R.id.etEmailAddress)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        val email = etEmailAddress.text.toString()
        val password = etPassword.text.toString()

        if (email.isBlank() || password.isBlank()){
            Toast.makeText(this, "kindly enter email and password", Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
            if (it.isSuccessful){
                Toast.makeText(this, "Sucess", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }
            else{
                Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
