package com.example.visitapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface VisitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(visit: Visit): Long

    @Query("SELECT * FROM visits WHERE checkOutTime IS NULL ORDER BY checkInTime DESC")
    fun getActiveVisits(): Flow<List<Visit>>

    @Query("SELECT * FROM visits ORDER BY checkInTime DESC")
    fun getAllVisits(): Flow<List<Visit>>

    @Query("UPDATE visits SET checkOutTime = :time WHERE id = :id")
    suspend fun updateCheckOut(id: Long, time: Long)

    @Query("UPDATE visits SET notes = :notes WHERE id = :id")
    suspend fun updateNotes(id: Long, notes: String?)

    // Añadir estas dos si no están:
    @Query("SELECT * FROM visits WHERE id = :id LIMIT 1")
    suspend fun getById(id: Long): Visit?

    @Query("DELETE FROM visits WHERE id = :id")
    suspend fun deleteById(id: Long)
}

