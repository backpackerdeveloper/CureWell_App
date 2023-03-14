package com.shubhamtripz.curewell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class InstantCureActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<CureDataClass>
    lateinit var imageList: Array<Int>
    lateinit var titleList: Array<String>
    lateinit var descList: Array<String>
    lateinit var detailImageList: Array<Int>
    private lateinit var myAdapter: CureAdapterClass
    private lateinit var searchView: androidx.appcompat.widget.SearchView
    private lateinit var searchList: ArrayList<CureDataClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instant_cure)


        imageList = arrayOf(
            R.drawable.ic_checkbox,
            R.drawable.ic_checkbox,
            R.drawable.ic_checkbox,
            R.drawable.ic_checkbox,
            R.drawable.ic_checkbox,
            R.drawable.ic_checkbox,
            R.drawable.ic_checkbox,
            R.drawable.ic_checkbox,
            R.drawable.ic_checkbox,
            R.drawable.ic_checkbox,
            R.drawable.ic_checkbox,
            R.drawable.ic_checkbox,
            R.drawable.ic_checkbox,
            R.drawable.ic_checkbox,
            R.drawable.ic_checkbox,
            R.drawable.ic_checkbox
        )
        titleList = arrayOf(
            "Asthma",
            "Burns",
            "Choking",
            "Diabetes",
            "Electrical Injury",
            "Fever",
            "Fracture",
            "Headache",
            "Heart Attack",
            "Near Drowning",
            "Panic Attack",
            "Poisioning",
            "Snake Bite",
            "Stomache",
            "Stroke",
            "Nose Bleeding"
        )
        descList = arrayOf(
            getString(R.string.asthma),
            getString(R.string.burns),
            getString(R.string.choking),
            getString(R.string.diabetes),
            getString(R.string.electrical_injury),
            getString(R.string.fever),
            getString(R.string.fracture),
            getString(R.string.headache),
            getString(R.string.heart_attack),
            getString(R.string.near_drowning),
            getString(R.string.panic_attack),
            getString(R.string.poisioning),
            getString(R.string.snakebite),
            getString(R.string.stomache),
            getString(R.string.stroke),
            getString(R.string.nose_bleeding)
        )
        detailImageList = arrayOf(
            R.drawable.asthmadp,
            R.drawable.burnsdp,
            R.drawable.chokingdp,
            R.drawable.diabitesdp,
            R.drawable.electricaldp,
            R.drawable.feverdp,
            R.drawable.fracturedp,
            R.drawable.headachedp,
            R.drawable.headachedp,
            R.drawable.neardrowningdp,
            R.drawable.panicattackdp,
            R.drawable.poisondp,
            R.drawable.snakebitedp,
            R.drawable.stomachedp,
            R.drawable.strokedp,
            R.drawable.nosebleedingdp
        )
        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.search)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        dataList = arrayListOf<CureDataClass>()
        searchList = arrayListOf<CureDataClass>()
        getData()
        searchView.clearFocus()
        searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                return true

            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()) {
                    dataList.forEach {
                        if (it.dataTitle.toLowerCase(Locale.getDefault()).contains(searchText)) {
                            searchList.add(it)
                        }
                    }
                    recyclerView.adapter!!.notifyDataSetChanged()
                } else {
                    searchList.clear()
                    searchList.addAll(dataList)
                    recyclerView.adapter!!.notifyDataSetChanged()
                }
                return false
            }
        })

        myAdapter = CureAdapterClass(searchList)
        recyclerView.adapter = myAdapter
        myAdapter.onItemClick = {
            val intent = Intent(this, CureDetailsActivity::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }
    }

    private fun getData() {
        for (i in imageList.indices) {
            val dataClass = CureDataClass(imageList[i], titleList[i], descList[i], detailImageList[i])
            dataList.add(dataClass)
        }
        searchList.addAll(dataList)
        recyclerView.adapter = CureAdapterClass(searchList)
    }
}