package com.example.visitapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Visit::class], version = 1, exportSchema = false)
abstract class VisitDatabase : RoomDatabase() {
    abstract fun visitDao(): VisitDao

    companion object {
        @Volatile private var INSTANCE: VisitDatabase? = null

        fun getDatabase(context: Context): VisitDatabase {
            return INSTANCE ?: synchronized(this) {
                val inst = Room.databaseBuilder(
                    context.applicationContext,
                    VisitDatabase::class.java,
                    "visits_db"
                )
                    // Durante desarrollo es práctico:
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = inst
                inst
            }
        }
    }
}
