package com.example.visitapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "visits")
data class Visit(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val checkInTime: Long,
    val checkOutTime: Long? = null,
    val notes: String? = null
)

