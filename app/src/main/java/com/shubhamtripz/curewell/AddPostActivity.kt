package com.shubhamtripz.curewell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class AddPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)

        val btnsave = findViewById<TextView>(R.id.btntSingUp)

        btnsave.setOnClickListener {

            val adtitle = findViewById<EditText>(R.id.adttitle)
            val addetail = findViewById<EditText>(R.id.addetail)
            val addate = findViewById<EditText>(R.id.addate)
            val adlocation = findViewById<EditText>(R.id.adlocation)
            val adcontact = findViewById<EditText>(R.id.adcontact)

            val titleName = adtitle.text.toString()
            val postName = addetail.text.toString()
            val date = addate.text.toString()
            val location = adlocation.text.toString()
            val contact = adcontact.text.toString()


            saveFireStore(titleName, postName, date, location, contact)

        }

    }

    private fun saveFireStore(titleName: String, postName: String, date: String, location: String, contact: String) {

        val db = FirebaseFirestore.getInstance()
        val User: MutableMap<String, Any> = HashMap()
        User["titleName"] = titleName
        User["postName"] = postName
        User["date"] = date
        User["location"] = location
        User["contact"] = contact


        db.collection("Users").add(User)
            .addOnSuccessListener {

                Toast.makeText(this, "Sucessfully Submitted", Toast.LENGTH_SHORT).show()

            }

            .addOnFailureListener {
                Toast.makeText(this, "Uploading Failed", Toast.LENGTH_SHORT).show()
            }


    }


}