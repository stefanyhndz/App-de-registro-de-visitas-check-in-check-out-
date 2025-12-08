package com.example.visitapp.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository que encapsula el acceso a la base de datos (VisitDao).
 * Provee flujos y funciones suspend para usarse desde el ViewModel.
 */
class VisitRepository(private val dao: VisitDao) {

    // Flujo con todas las visitas (historial completo)
    val allVisits: Flow<List<Visit>> = dao.getAllVisits()

    // Flujo con solo visitas activas (checkOutTime == null)
    val activeVisits: Flow<List<Visit>> = dao.getActiveVisits()

    // Inserta una visita (check-in). Devuelve el id generado.
    suspend fun insertVisit(visit: Visit): Long {
        return dao.insert(visit)
    }

    // Marca check-out de una visita existente
    suspend fun checkOut(id: Long) {
        dao.updateCheckOut(id, System.currentTimeMillis())
    }

    // Actualiza la nota de una visita
    suspend fun updateNotes(id: Long, notes: String?) {
        dao.updateNotes(id, notes)
    }

    // Borra una visita por id (si tu DAO tiene delete)
    suspend fun delete(id: Long) {
        dao.deleteById(id)
    }

    // Recupera una visita por id (si tu DAO tiene getById)
    suspend fun getById(id: Long): Visit? {
        return dao.getById(id)
    }
}

