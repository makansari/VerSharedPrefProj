package com.example.versharedprefproj

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sp : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*sp = getSharedPreferences("myfile", MODE_PRIVATE)
       editUserName.setText(sp.getString("username",""))*/
        var db = Room.databaseBuilder(this,StudentDb::class.java,"studentdatabase").fallbackToDestructiveMigration().build()
        var h = Handler()

        buttonsave.setOnClickListener {
           /* var editor = sp.edit()
            editor.putString("username",editUserName.text.toString()).commit()*/
            Thread{

                var username = editUserName.text.toString()
                var email = editTextEmail.text.toString()

                var student = StudentEntity()

                student.username = username
                student.email = email

                db.studentDao().saveData(student)

                runOnUiThread {
                    editUserName.setText("")
                    editTextEmail.setText("")  }


            }.start()

        }

        buttonShow.setOnClickListener {
            Thread{
                db.studentDao().readData().forEach {
                    h.post {
                        var data = "student name is ${it.username}  with email ${it.email}"
                        Toast.makeText(this, "" + data, Toast.LENGTH_LONG).show()
                    }

                    runOnUiThread {

                    }
                }
            }.start()

        }
    }
}