package com.example.visitapp.data

import kotlinx.coroutines.flow.Flow

interface VisitRepository {
    val visits: Flow<List<Visit>>
    suspend fun checkIn(notes: String?): Long
    suspend fun checkOut(id: Long)
    suspend fun updateNotes(id: Long, notes: String?)
    suspend fun delete(id: Long)
    suspend fun getById(id: Long): Visit?

    // nuevo: permite reinsertar exactamente una entidad (útil para undo)
    suspend fun insertVisit(visit: Visit): Long
}

class VisitRepositoryImpl(private val dao: VisitDao) : VisitRepository {
    override val visits: Flow<List<Visit>> = dao.getAll()

    override suspend fun checkIn(notes: String?): Long {
        val now = System.currentTimeMillis()
        val visit = Visit(checkInTime = now, notes = notes)
        return dao.insert(visit)
    }

    override suspend fun checkOut(id: Long) {
        val now = System.currentTimeMillis()
        dao.setCheckOutTime(id, now)
    }

    override suspend fun updateNotes(id: Long, notes: String?) {
        val v = dao.getById(id) ?: return
        dao.update(v.copy(notes = notes))
    }

    override suspend fun delete(id: Long) {
        dao.deleteById(id)
    }

    override suspend fun getById(id: Long): Visit? = dao.getById(id)

    // Implementación añadida para cumplir la interfaz
    override suspend fun insertVisit(visit: Visit): Long {
        return dao.insert(visit)
    }
}
