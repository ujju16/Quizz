package com.example.quizz.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question_table")

data class QuestionEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val text: String,
    val answer: String
)
