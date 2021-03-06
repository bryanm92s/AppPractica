package com.example.apppractica.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.apppractica.dao.DaoAccess
import com.example.apppractica.entity.User


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun daoAccess(): DaoAccess

    companion object {

        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase? {

            if (INSTANCE == null) synchronized(UserDatabase::class.java) {

                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(
                        context, UserDatabase::class.java, "USER_DATABASE"
                    ).allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}