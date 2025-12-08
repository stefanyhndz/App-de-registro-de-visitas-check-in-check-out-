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

class VisitsViewModel(private val repo: VisitRepository) : ViewModel() {

    // Historial completo
    val allVisits: StateFlow<List<Visit>> =
        repo.allVisits
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Solo visitas activas
    val activeVisits: StateFlow<List<Visit>> =
        repo.activeVisits
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // UI combinado (historial + id activo)
    private val _uiState: StateFlow<VisitsUiState> = combine(allVisits, activeVisits) { all, active ->
        val activeId = active.firstOrNull()?.id
        VisitsUiState(visits = all, activeVisitId = activeId)
    }.stateIn(viewModelScope, SharingStarted.Eagerly, VisitsUiState())

    val uiState: StateFlow<VisitsUiState> = _uiState

    /** Check-in: ahora acepta name, phone y notes por separado */
    fun checkIn(name: String?, phone: String?, notes: String?) {
        viewModelScope.launch {
            val visit = Visit(
                name = name?.takeIf { it.isNotBlank() },
                phone = phone?.takeIf { it.isNotBlank() },
                checkInTime = System.currentTimeMillis(),
                notes = notes?.takeIf { it.isNotBlank() }
            )
            repo.insertVisit(visit)
        }
    }

    /** Mantener compatibilidad: si antes existía checkInWithNotes */
    fun checkInWithNotes(notes: String?) {
        // si se usa en algún lugar legacy, lo traducimos a la nueva función sin name/phone
        checkIn(null, null, notes)
    }

    fun checkOutCurrent() {
        val active = activeVisits.value.firstOrNull() ?: return
        viewModelScope.launch {
            repo.checkOut(active.id)
        }
    }

    fun checkOutById(id: Long) {
        viewModelScope.launch {
            repo.checkOut(id)
        }
    }

    fun updateNotes(id: Long, notes: String?) {
        viewModelScope.launch {
            repo.updateNotes(id, notes)
        }
    }

    fun deleteVisit(id: Long) {
        viewModelScope.launch {
            repo.delete(id)
        }
    }

    suspend fun getVisitById(id: Long): Visit? = repo.getById(id)

    fun reinsertVisit(visit: Visit) {
        viewModelScope.launch {
            repo.insertVisit(visit)
        }
    }
}
