package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var vvod_sum: TextView
    lateinit var sharedPreferences: SharedPreferences
    val myPreferences = "mypref"
    val vvod_sumkey = "VvodKey"


     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vvod_sum = findViewById(R.id.vvod_sum)
        sharedPreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        if (sharedPreferences.contains(vvod_sumkey)) {
           tek_view.text = sharedPreferences.getString(vvod_sumkey,"")
        }
    }
    fun saveData(view: View){
        val vvodStr = vvod_sum.text.toString()
        val editor = sharedPreferences.edit()
        editor.putString(vvod_sumkey,vvodStr)
        editor.commit()
        Toast.makeText(applicationContext,"Data Saved...",Toast.LENGTH_SHORT).show()
        vvod_sum.text = ""
        sharedPreferences = getSharedPreferences(myPreferences,Context.MODE_PRIVATE)
        if(sharedPreferences.contains(vvod_sumkey)){
            tek_view.text = sharedPreferences.getString(vvod_sumkey,"")
        }
    }
     fun readData(view: View){
         sharedPreferences = getSharedPreferences(myPreferences,Context.MODE_PRIVATE)
         if(sharedPreferences.contains(vvod_sumkey)){
             tek_view.text = sharedPreferences.getString(vvod_sumkey,"")
         }
         Toast.makeText(applicationContext,"Data Retrieved...", Toast.LENGTH_SHORT).show()
    }

}
