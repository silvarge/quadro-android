package com.todo.quadro.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.todo.quadro.data.model.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class QuadroDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao

    companion object {
        @Volatile
        private var INSTANCE: QuadroDatabase? = null

        fun getDatabase(context: Context): QuadroDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuadroDatabase::class.java,
                    "quadro_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
