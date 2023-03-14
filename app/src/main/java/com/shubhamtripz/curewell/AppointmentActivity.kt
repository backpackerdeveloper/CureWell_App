package com.shubhamtripz.curewell

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AppointmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)

        val cureclicnic = findViewById<TextView>(R.id.cureclinicbtn)

        cureclicnic.setOnClickListener{
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://pmny.in/LIUMsOHPxPc6")
            startActivity(openURL)
        }

    }
}