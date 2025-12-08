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

    private val _uiState = repo.visits
        .map { visits ->
            val active = visits.firstOrNull { it.checkOutTime == null }?.id
            VisitsUiState(visits = visits, activeVisitId = active)
        }
        .stateIn(viewModelScope, SharingStarted.Eagerly, VisitsUiState())

    val uiState: StateFlow<VisitsUiState> = _uiState

    fun checkInWithNotes(notes: String?) {
        viewModelScope.launch { repo.checkIn(notes) }
    }

    fun checkOutCurrent() {
        val activeId = _uiState.value.activeVisitId ?: return
        viewModelScope.launch { repo.checkOut(activeId) }
    }

    fun deleteVisit(id: Long) {
        viewModelScope.launch { repo.delete(id) }
    }

    fun updateNotes(id: Long, notes: String?) {
        viewModelScope.launch { repo.updateNotes(id, notes) }
    }

    suspend fun getVisitById(id: Long): Visit? = repo.getById(id)

    fun reinsertVisit(visit: com.example.visitapp.data.Visit) {
        viewModelScope.launch {
            repo.insertVisit(visit)
        }
    }
}

