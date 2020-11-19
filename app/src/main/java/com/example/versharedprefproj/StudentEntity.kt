package com.example.versharedprefproj

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "student_tbl")
class StudentEntity {
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "id_col")
    var id : Int = 0

    @ColumnInfo(name = "username_col")
    var username : String = ""

    @ColumnInfo(name = "email_col")
    var email : String = ""
}