package com.example.visitapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Visit::class], version = 2)
abstract class VisitDatabase : RoomDatabase() {
    abstract fun visitDao(): VisitDao

    companion object {
        @Volatile
        private var INSTANCE: VisitDatabase? = null

        fun getDatabase(context: Context): VisitDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VisitDatabase::class.java,
                    "visit_db"
                )
                    // Si quieres mantener datos entre versiones implementa migraciones.
                    // Aquí añadimos la migración 1 -> 2 que agrega columnas name y phone.
                    .addMigrations(MIGRATION_1_2)
                    .build()
                INSTANCE = instance
                instance
            }
        }

        // Migración 1 -> 2: añade columnas name y phone (ambas NULLABLE)
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE visits ADD COLUMN name TEXT")
                database.execSQL("ALTER TABLE visits ADD COLUMN phone TEXT")
            }
        }
    }
}
