package com.example.quizz.data.repositories

import com.example.quizz.data.dao.QuestionDao
import com.example.quizz.data.model.QuestionEntity
import kotlinx.coroutines.flow.Flow

class QuestionRepository(private val questionDao: QuestionDao) {

    fun getAllQuestions(): Flow<MutableList<QuestionEntity>> {
        return questionDao.getAllQuestions()
    }

    fun insertQuestion(question: QuestionEntity) {
        questionDao.insertQuestion(question)
    }
}