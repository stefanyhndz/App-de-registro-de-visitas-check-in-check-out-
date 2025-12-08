package com.example.visitapp.ui;

import androidx.lifecycle.ViewModel;
import com.example.visitapp.data.Visit;
import com.example.visitapp.data.VisitRepository;
import kotlinx.coroutines.flow.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0017\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0012J\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u001b\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\nJ\u0018\u0010!\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/example/visitapp/ui/VisitsViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/example/visitapp/data/VisitRepository;", "(Lcom/example/visitapp/data/VisitRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/visitapp/ui/VisitsUiState;", "activeVisits", "", "Lcom/example/visitapp/data/Visit;", "getActiveVisits", "()Lkotlinx/coroutines/flow/StateFlow;", "allVisits", "getAllVisits", "uiState", "getUiState", "checkIn", "", "name", "", "phone", "notes", "checkInWithNotes", "checkOutById", "id", "", "checkOutCurrent", "deleteVisit", "getVisitById", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reinsertVisit", "visit", "updateNotes", "app_debug"})
public final class VisitsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.visitapp.data.VisitRepository repo = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.visitapp.data.Visit>> allVisits = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.visitapp.data.Visit>> activeVisits = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.visitapp.ui.VisitsUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.visitapp.ui.VisitsUiState> uiState = null;
    
    public VisitsViewModel(@org.jetbrains.annotations.NotNull
    com.example.visitapp.data.VisitRepository repo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.visitapp.data.Visit>> getAllVisits() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.visitapp.data.Visit>> getActiveVisits() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.visitapp.ui.VisitsUiState> getUiState() {
        return null;
    }
    
    /**
     * Check-in: ahora acepta name, phone y notes por separado
     */
    public final void checkIn(@org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.String phone, @org.jetbrains.annotations.Nullable
    java.lang.String notes) {
    }
    
    /**
     * Mantener compatibilidad: si antes existía checkInWithNotes
     */
    public final void checkInWithNotes(@org.jetbrains.annotations.Nullable
    java.lang.String notes) {
    }
    
    public final void checkOutCurrent() {
    }
    
    public final void checkOutById(long id) {
    }
    
    public final void updateNotes(long id, @org.jetbrains.annotations.Nullable
    java.lang.String notes) {
    }
    
    public final void deleteVisit(long id) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getVisitById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.visitapp.data.Visit> $completion) {
        return null;
    }
    
    public final void reinsertVisit(@org.jetbrains.annotations.NotNull
    com.example.visitapp.data.Visit visit) {
    }
}