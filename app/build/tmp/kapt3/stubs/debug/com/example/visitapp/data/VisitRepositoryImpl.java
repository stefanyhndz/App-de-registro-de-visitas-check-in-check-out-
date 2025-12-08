package com.example.visitapp.data;

import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J#\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/example/visitapp/data/VisitRepositoryImpl;", "Lcom/example/visitapp/data/VisitRepository;", "dao", "Lcom/example/visitapp/data/VisitDao;", "(Lcom/example/visitapp/data/VisitDao;)V", "visits", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/visitapp/data/Visit;", "getVisits", "()Lkotlinx/coroutines/flow/Flow;", "checkIn", "", "notes", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkOut", "", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "getById", "insertVisit", "visit", "(Lcom/example/visitapp/data/Visit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotes", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class VisitRepositoryImpl implements com.example.visitapp.data.VisitRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.visitapp.data.VisitDao dao = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.visitapp.data.Visit>> visits = null;
    
    public VisitRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.example.visitapp.data.VisitDao dao) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<com.example.visitapp.data.Visit>> getVisits() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object checkIn(@org.jetbrains.annotations.Nullable
    java.lang.String notes, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object checkOut(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateNotes(long id, @org.jetbrains.annotations.Nullable
    java.lang.String notes, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object delete(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.visitapp.data.Visit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertVisit(@org.jetbrains.annotations.NotNull
    com.example.visitapp.data.Visit visit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
}