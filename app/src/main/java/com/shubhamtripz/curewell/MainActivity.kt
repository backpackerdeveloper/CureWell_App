package com.shubhamtripz.curewell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coupbtn = findViewById<LinearLayout>(R.id.couponbtn)

        coupbtn.setOnClickListener {
            val intent = Intent(this, InstantCureActivity::class.java)
            startActivity(intent)
        }

        val postbtn = findViewById<ConstraintLayout>(R.id.tshirtbtn)

        postbtn.setOnClickListener {

            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)

        }

        val bookbt = findViewById<ConstraintLayout>(R.id.bookbtn)

        bookbt.setOnClickListener {

            val intent = Intent(this, AppointmentActivity::class.java)
            startActivity(intent)

        }


    }
}