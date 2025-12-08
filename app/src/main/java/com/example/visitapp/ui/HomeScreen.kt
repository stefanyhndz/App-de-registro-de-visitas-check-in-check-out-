package com.example.visitapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.visitapp.data.Visit
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: VisitsViewModel, onGoToHistory: () -> Unit) {
    val state by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var showCheckInForm by remember { mutableStateOf(false) }
    var editNotesForVisit by remember { mutableStateOf<Visit?>(null) }
    var confirmDeleteForVisit by remember { mutableStateOf<Visit?>(null) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Registro de visitas") },
                actions = {
                    TextButton(onClick = onGoToHistory) {
                        Text("Historial")
                    }
                }
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            ActionButtons(
                state = state,
                onCheckIn = { showCheckInForm = true },
                onCheckOut = { viewModel.checkOutCurrent() }
            )
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            VisitList(
                visits = state.visits,
                onEditNotes = { editNotesForVisit = it },
                onDelete = { confirmDeleteForVisit = it }
            )
        }
    }

    // --- Check-in form dialog (nuevo) --- pass separate fields to ViewModel
    if (showCheckInForm) {
        CheckInFormDialog(
            onConfirm = { name, phone, notes ->
                // dado que CheckInFormDialog pasa name y phone como NON-null (String),
                // usamos takeIf para convertir cadenas vacías a null de forma segura.
                viewModel.checkIn(
                    name.takeIf { it.isNotBlank() },
                    phone.takeIf { it.isNotBlank() },
                    notes?.takeIf { it.isNotBlank() }
                )
                showCheckInForm = false
            },
            onDismiss = { showCheckInForm = false }
        )
    }

    // --- Edit notes dialog (existente)
    editNotesForVisit?.let { visit ->
        NotesDialog(
            initial = visit.notes ?: "",
            title = "Editar notas",
            onConfirm = { notes ->
                viewModel.updateNotes(visit.id, notes.ifBlank { null })
                editNotesForVisit = null
                scope.launch {
                    snackbarHostState.showSnackbar("Notas actualizadas")
                }
            },
            onDismiss = { editNotesForVisit = null }
        )
    }

    // --- Confirm delete with undo
    confirmDeleteForVisit?.let { visit ->
        ConfirmDialog(
            title = "Eliminar registro",
            text = "¿Eliminar registro de ${formatDate(visit.checkInTime)} ?",
            onConfirm = {
                val deleted = visit.copy()
                viewModel.deleteVisit(visit.id)
                confirmDeleteForVisit = null

                scope.launch {
                    val result = snackbarHostState.showSnackbar(
                        message = "Registro eliminado",
                        actionLabel = "Deshacer",
                        duration = SnackbarDuration.Short
                    )
                    if (result == SnackbarResult.ActionPerformed) {
                        viewModel.reinsertVisit(deleted)
                    }
                }
            },
            onDismiss = { confirmDeleteForVisit = null }
        )
    }
}

/* ---------------- UI pieces ---------------- */

@Composable
fun ActionButtons(state: VisitsUiState, onCheckIn: () -> Unit, onCheckOut: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = onCheckIn, enabled = state.activeVisitId == null, modifier = Modifier.weight(1f)) {
            Text(text = "Check-in")
        }
        Button(onClick = onCheckOut, enabled = state.activeVisitId != null, modifier = Modifier.weight(1f)) {
            Text(text = "Check-out")
        }
    }
}

@Composable
fun VisitList(visits: List<Visit>, onEditNotes: (Visit) -> Unit, onDelete: (Visit) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(12.dp)) {
        items(visits, key = { it.id }) { v ->
            VisitCard(
                visit = v,
                onEditNotes = { onEditNotes(v) },
                onDelete = { onDelete(v) }
            )
        }
    }
}

@Composable
fun VisitCard(visit: Visit, onEditNotes: () -> Unit, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        // Recomendado para Material3 moderno:
        elevation = CardDefaults.outlinedCardElevation() // o CardDefaults.cardElevation() según tu versión
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            val fmt = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
            val entrada = safeFormat(fmt, visit.checkInTime)
            val salida = visit.checkOutTime?.let { safeFormat(fmt, it) } ?: "--"
            val dur = visit.checkOutTime?.let { durationText(visit.checkInTime, it) } ?: "En curso"

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Entrada: $entrada", fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Salida: $salida", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = "Duración: $dur", style = MaterialTheme.typography.bodySmall)
                    Spacer(modifier = Modifier.height(8.dp))

                    // Nombre separado
                    if (!visit.name.isNullOrBlank()) {
                        Text(text = "Nombre: ${visit.name}", style = MaterialTheme.typography.bodyMedium)
                        Spacer(modifier = Modifier.height(4.dp))
                    }

                    // Teléfono separado
                    if (!visit.phone.isNullOrBlank()) {
                        Text(text = "Teléfono: ${visit.phone}", style = MaterialTheme.typography.bodySmall)
                        Spacer(modifier = Modifier.height(6.dp))
                    }

                    // Notas separado
                    if (!visit.notes.isNullOrBlank()) {
                        Text(text = "Notas:", style = MaterialTheme.typography.bodySmall)
                        Text(text = visit.notes.orEmpty(), style = MaterialTheme.typography.bodySmall)
                    } else {
                        Text(text = "Notas: --", style = MaterialTheme.typography.bodySmall)
                    }
                }
                Column(horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    IconButton(onClick = onEditNotes) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Editar notas")
                    }
                    IconButton(onClick = onDelete) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Eliminar")
                    }
                }
            }
        }
    }
}

/* Helper: Check-in form dialog */
@Composable
fun CheckInFormDialog(
    onConfirm: (name: String, phone: String, notes: String?) -> Unit,
    onDismiss: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Registro de Check-in") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Nombre del visitante") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    label = { Text("Teléfono") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = notes,
                    onValueChange = { notes = it },
                    label = { Text("Notas adicionales (opcional)") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if (name.isNotBlank()) {
                        onConfirm(name.trim(), phone.trim(), notes.ifBlank { null })
                    }
                }
            ) {
                Text("Aceptar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}

/* Helper: Dialog para editar notas */
@Composable
fun NotesDialog(initial: String, title: String = "Notas", onConfirm: (String) -> Unit, onDismiss: () -> Unit) {
    var text by remember { mutableStateOf(initial) }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title) },
        text = {
            Column {
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Notas") },
                    placeholder = { Text("Ej. Cliente, motivo...") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            TextButton(onClick = { onConfirm(text.trim()) }) {
                Text("Aceptar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}

/* Helper: Confirm dialog genérico */
@Composable
fun ConfirmDialog(title: String, text: String, onConfirm: () -> Unit, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title) },
        text = { Text(text) },
        confirmButton = {
            TextButton(onClick = onConfirm) { Text("Eliminar") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Cancelar") }
        }
    )
}

/* Utils (puedes mantener las tuyas si ya existen) */
fun safeFormat(fmt: SimpleDateFormat, time: Long): String = try {
    fmt.format(Date(time))
} catch (_: Exception) { "--" }

fun formatDate(time: Long): String = try {
    val fmt = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
    fmt.format(Date(time))
} catch (_: Exception) { "--" }

fun durationText(start: Long, end: Long): String {
    val diffMs = end - start
    if (diffMs <= 0) return "0m"
    val minutes = diffMs / 60000
    val hours = minutes / 60
    val mins = minutes % 60
    return if (hours > 0) "${hours}h ${mins}m" else "${mins}m"
}
