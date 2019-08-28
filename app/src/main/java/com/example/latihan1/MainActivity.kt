package com.example.latihan1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val list = findViewById<RecyclerView>(R.id.club_list)
        initData()

//        list.layoutManager = LinearLayoutManager(this)
//        list.adapter = RecyclerViewAdapter(this, items){
//            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
//            toast.show()
//        }
        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items){
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    private var items: MutableList<Item> = mutableListOf()

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.clib_image)

        items.clear()
        for (i in name.indices){
            items.add(Item(name[i], image.getResourceId(i,0)))
        }

        //Recycler the typed array
        image.recycle()
    }
}
