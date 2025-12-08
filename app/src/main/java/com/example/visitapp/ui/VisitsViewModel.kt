package com.example.visitapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.visitapp.data.Visit
import com.example.visitapp.data.VisitRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class VisitsUiState(
    val visits: List<Visit> = emptyList(),
    val activeVisitId: Long? = null
)

/**
 * ViewModel que expone:
 *  - allVisits: historial completo (StateFlow)
 *  - activeVisits: solo visitas activas (StateFlow)
 *  - uiState: combinacion (opcional) para UI que lo requiera
 *
 * Provee funciones para check-in, check-out, updateNotes, delete y obtener visita por id.
 */
class VisitsViewModel(private val repo: VisitRepository) : ViewModel() {

    // Historial completo
    val allVisits: StateFlow<List<Visit>> =
        repo.allVisits
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Solo visitas activas
    val activeVisits: StateFlow<List<Visit>> =
        repo.activeVisits
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // UI state combinando ambos (útil si tienes pantallas que necesitan ambos datos)
    private val _uiState: StateFlow<VisitsUiState> = combine(allVisits, activeVisits) { all, active ->
        val activeId = active.firstOrNull()?.id
        VisitsUiState(visits = all, activeVisitId = activeId)
    }.stateIn(viewModelScope, SharingStarted.Eagerly, VisitsUiState())

    val uiState: StateFlow<VisitsUiState> = _uiState

    /**
     * Check-in: crea una nueva visita con la nota (notes) recibida.
     */
    fun checkInWithNotes(notes: String?) {
        viewModelScope.launch {
            val visit = Visit(
                checkInTime = System.currentTimeMillis(),
                notes = notes
            )
            repo.insertVisit(visit)
        }
    }

    /**
     * Check-out del primer registro activo (si existe).
     * Alternativamente podrías proporcionar el id a la función.
     */
    fun checkOutCurrent() {
        val active = activeVisits.value.firstOrNull() ?: return
        viewModelScope.launch {
            repo.checkOut(active.id)
        }
    }

    /**
     * Check-out por id explícito
     */
    fun checkOutById(id: Long) {
        viewModelScope.launch {
            repo.checkOut(id)
        }
    }

    /**
     * Actualizar notas
     */
    fun updateNotes(id: Long, notes: String?) {
        viewModelScope.launch {
            repo.updateNotes(id, notes)
        }
    }

    /**
     * Borrar visita
     */
    fun deleteVisit(id: Long) {
        viewModelScope.launch {
            repo.delete(id)
        }
    }

    /**
     * Obtener visita por id (suspend, útil en screens que necesitan cargar detalle)
     */
    suspend fun getVisitById(id: Long): Visit? = repo.getById(id)

    /**
     * Reinsertar una visita (por ejemplo: undo). Se usa para reinsertar un objeto Visit completo.
     */
    fun reinsertVisit(visit: Visit) {
        viewModelScope.launch {
            repo.insertVisit(visit)
        }
    }
}


