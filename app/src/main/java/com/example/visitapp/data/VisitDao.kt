package com.example.visitapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface VisitDao {
    @Query("SELECT * FROM visits ORDER BY checkInTime DESC")
    fun getAll(): Flow<List<Visit>>

    @Insert
    suspend fun insert(visit: Visit): Long

    @Update
    suspend fun update(visit: Visit)

    @Query("UPDATE visits SET checkOutTime = :time WHERE id = :id")
    suspend fun setCheckOutTime(id: Long, time: Long)

    @Query("DELETE FROM visits WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("SELECT * FROM visits WHERE id = :id LIMIT 1")
    suspend fun getById(id: Long): Visit?
}
