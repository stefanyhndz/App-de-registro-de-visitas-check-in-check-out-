package com.example.visitapp.data;

import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u001b\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J#\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017R\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/example/visitapp/data/VisitRepository;", "", "visits", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/visitapp/data/Visit;", "getVisits", "()Lkotlinx/coroutines/flow/Flow;", "checkIn", "", "notes", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkOut", "", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "getById", "insertVisit", "visit", "(Lcom/example/visitapp/data/Visit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotes", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface VisitRepository {
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.visitapp.data.Visit>> getVisits();
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object checkIn(@org.jetbrains.annotations.Nullable
    java.lang.String notes, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object checkOut(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateNotes(long id, @org.jetbrains.annotations.Nullable
    java.lang.String notes, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object delete(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.visitapp.data.Visit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertVisit(@org.jetbrains.annotations.NotNull
    com.example.visitapp.data.Visit visit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
}