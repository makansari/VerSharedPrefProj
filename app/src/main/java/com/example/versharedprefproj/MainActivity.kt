package com.example.versharedprefproj

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sp : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sp = getSharedPreferences("myfile", MODE_PRIVATE)
       editUserName.setText(sp.getString("username",""))

        button.setOnClickListener {
            var editor = sp.edit()
            editor.putString("username",editUserName.text.toString()).commit()
        }
    }
}