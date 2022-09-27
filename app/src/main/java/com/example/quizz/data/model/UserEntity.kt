package com.example.quizz.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")

data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val username: String,
    val pass: String,
    val score: Int
)
