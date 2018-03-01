package com.firman.kotlinarchitecture.repository.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.firman.kotlinarchitecture.repository.data.User

/**
 * Created by firman on 01/03/18.
 */
@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
}
