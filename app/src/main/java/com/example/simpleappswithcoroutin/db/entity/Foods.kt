package com.example.simpleappswithcoroutin.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "foods")
data class Foods (
    @PrimaryKey
    @ColumnInfo (name = "id")
    val foodsId: Long,
    val name : String,
    val description: String,
    val growZoneNumber: Int,
    val foodsInterval: Int = 7, // how often the plant should be watered, in days
    val imageUrl: String = ""
)