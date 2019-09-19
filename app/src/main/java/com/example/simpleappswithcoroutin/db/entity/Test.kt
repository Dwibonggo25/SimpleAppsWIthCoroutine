package com.example.simpleappswithcoroutin.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity ( tableName = "test")
data class Test (

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id : Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "body")
    val body: String,

    @ColumnInfo (name = "userId")
    val userId: Int
)
