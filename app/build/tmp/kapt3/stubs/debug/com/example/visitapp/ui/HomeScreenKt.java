package com.example.visitapp.ui;

import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import com.example.visitapp.data.Visit;
import java.text.SimpleDateFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001ae\u0010\u0007\u001a\u00020\u00012M\u0010\b\u001aI\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a4\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u001e\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a<\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\n2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00192\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a,\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a>\u0010\u001f\u001a\u00020\u00012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0!2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\u00192\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\u0019H\u0007\u001a\u0016\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$\u001a\u000e\u0010&\u001a\u00020\n2\u0006\u0010\'\u001a\u00020$\u001a\u0016\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020*2\u0006\u0010\'\u001a\u00020$\u00a8\u0006+"}, d2 = {"ActionButtons", "", "state", "Lcom/example/visitapp/ui/VisitsUiState;", "onCheckIn", "Lkotlin/Function0;", "onCheckOut", "CheckInFormDialog", "onConfirm", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "phone", "notes", "onDismiss", "ConfirmDialog", "title", "text", "MainScreen", "viewModel", "Lcom/example/visitapp/ui/VisitsViewModel;", "onGoToHistory", "NotesDialog", "initial", "Lkotlin/Function1;", "VisitCard", "visit", "Lcom/example/visitapp/data/Visit;", "onEditNotes", "onDelete", "VisitList", "visits", "", "durationText", "start", "", "end", "formatDate", "time", "safeFormat", "fmt", "Ljava/text/SimpleDateFormat;", "app_debug"})
public final class HomeScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void MainScreen(@org.jetbrains.annotations.NotNull
    com.example.visitapp.ui.VisitsViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onGoToHistory) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ActionButtons(@org.jetbrains.annotations.NotNull
    com.example.visitapp.ui.VisitsUiState state, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onCheckIn, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onCheckOut) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void VisitList(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.visitapp.data.Visit> visits, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.visitapp.data.Visit, kotlin.Unit> onEditNotes, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.visitapp.data.Visit, kotlin.Unit> onDelete) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void VisitCard(@org.jetbrains.annotations.NotNull
    com.example.visitapp.data.Visit visit, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onEditNotes, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void CheckInFormDialog(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.String, ? super java.lang.String, kotlin.Unit> onConfirm, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void NotesDialog(@org.jetbrains.annotations.NotNull
    java.lang.String initial, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onConfirm, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ConfirmDialog(@org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String text, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onConfirm, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String safeFormat(@org.jetbrains.annotations.NotNull
    java.text.SimpleDateFormat fmt, long time) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String formatDate(long time) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String durationText(long start, long end) {
        return null;
    }
}