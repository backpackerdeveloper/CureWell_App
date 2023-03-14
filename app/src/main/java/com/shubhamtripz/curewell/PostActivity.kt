package com.shubhamtripz.curewell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.*
import com.shubhamtripz.curewell.Adapter.MyAdapter
import com.shubhamtripz.curewell.Model.User

class PostActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<User>
    private lateinit var myAdapter: MyAdapter
    private lateinit var db : FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        val pushdata = findViewById<FloatingActionButton>(R.id.pushbtn)

        pushdata.setOnClickListener {
            val intent = Intent(this, AddPostActivity::class.java)
            startActivity(intent)
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf()

        myAdapter = MyAdapter(userArrayList)

        recyclerView.adapter = myAdapter

        EventChangeListener()

    }

    private fun EventChangeListener(){

        db  = FirebaseFirestore.getInstance()
        db.collection("Users").orderBy("date", Query.Direction.DESCENDING)
            .addSnapshotListener(object : EventListener<QuerySnapshot> {
                override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {

                    if (error!= null){

                        Log.e("FireStore error", error.message.toString())
                        return
                    }

                    for (dc: DocumentChange in value?.documentChanges!!){

                        if (dc.type == DocumentChange.Type.ADDED){

                            userArrayList.add(dc.document.toObject(User::class.java))
                        }
                    }

                    myAdapter.notifyDataSetChanged()

                }


            })
    }


}