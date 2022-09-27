package com.example.quizz.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.quizz.data.model.QuestionEntity
import kotlinx.coroutines.flow.Flow


@Dao

interface QuestionDao {

    @Query("DELETE FROM question_table")
    fun deleteAll()

    @Query("SELECT * FROM question_table")
    fun getAllQuestions(): Flow<MutableList<QuestionEntity>>

    @Query("SELECT COUNT(*) FROM question_table")
    fun count(): Int

    @Insert
    fun insertQuestion(user: QuestionEntity)
}