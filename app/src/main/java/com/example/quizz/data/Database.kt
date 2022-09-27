package com.example.quizz.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.quizz.data.model.QuestionEntity
import com.example.quizz.data.model.UserEntity

//@TypeConverters(RoomConverter::class)
@androidx.room.Database(
    entities = [UserEntity::class, QuestionEntity::class],
    version = 1,
    exportSchema = false
)

abstract class Database: RoomDatabase() {

//    abstract fun questionDao(): QuestionDao
//    abstract fun userDao(): UserDao

    companion object {
        var INSTANCE: Database? = null

        fun getDatabase(context: Context): Database? {
            if (INSTANCE == null) {
                synchronized(Database::class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            Database::class.java,
                            "database"
                        ).build()
                    }
                }
            }
            return INSTANCE
        }
    }
}

//TODO: Faire les DAO des classes Entities