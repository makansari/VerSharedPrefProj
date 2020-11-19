package com.example.versharedprefproj

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StudentEntity::class],version = 3)
abstract class StudentDb : RoomDatabase() {

    abstract  fun studentDao() : StudentDAO
}