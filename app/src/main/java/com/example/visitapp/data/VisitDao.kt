package com.example.visitapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface VisitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(visit: Visit): Long

    // Solo visitas activas (checkOutTime == null)
    @Query("SELECT * FROM visits WHERE checkOutTime IS NULL ORDER BY checkInTime DESC")
    fun getActiveVisits(): Flow<List<Visit>>

    // TODO: historial completo (incluye checkOutTime != null)
    @Query("SELECT * FROM visits ORDER BY checkInTime DESC")
    fun getAllVisits(): Flow<List<Visit>>

    // marcar check-out
    @Query("UPDATE visits SET checkOutTime = :time WHERE id = :id")
    suspend fun updateCheckOut(id: Long, time: Long)

    // actualizar notas
    @Query("UPDATE visits SET notes = :notes WHERE id = :id")
    suspend fun updateNotes(id: Long, notes: String?)

    @Query("SELECT * FROM visits WHERE id = :id LIMIT 1")
    suspend fun getById(id: Long): Visit?

    @Query("DELETE FROM visits WHERE id = :id")
    suspend fun deleteById(id: Long)

}
