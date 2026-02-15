package com.todo.quadro.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.todo.quadro.data.model.Quadrant
import com.todo.quadro.data.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Query("SELECT * FROM todos WHERE quadrant = :quadrant ORDER BY isCompleted ASC, createdAt DESC")
    fun getTodosByQuadrant(quadrant: Quadrant): Flow<List<Todo>>

    @Query("SELECT * FROM todos ORDER BY isCompleted ASC, createdAt DESC")
    fun getAllTodos(): Flow<List<Todo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo): Long

    @Update
    suspend fun updateTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Query("UPDATE todos SET isCompleted = :isCompleted, completedAt = :completedAt WHERE id = :id")
    suspend fun updateCompletionStatus(id: Long, isCompleted: Boolean, completedAt: Long?)
}
