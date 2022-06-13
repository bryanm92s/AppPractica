package com.example.apppractica.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.apppractica.entity.User



@Dao
interface DaoAccess {


    @Insert
    fun insertUserData(user: User)

    @Query("select * from User")
    fun getDetails(): LiveData<List<User>>

    @Query("DELETE FROM User WHERE id = :id")
    fun deleteByUserId(id: Long)
}