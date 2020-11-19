package com.example.versharedprefproj

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO  {

    @Insert
    fun saveData(studentEntity: StudentEntity)

    @Query ("select * from student_tbl")
    fun readData():List<StudentEntity>
}