package com.example.quizz.data.repositories

import com.example.quizz.data.dao.UserDao
import com.example.quizz.data.model.UserEntity

class UserRepository(private val userDao: UserDao) {

    fun getUser(username: String, pass: String): UserEntity {
        return userDao.getUser(username, pass)
    }

    fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    fun updateUser(user: UserEntity) {
        userDao.update(user)
    }
}