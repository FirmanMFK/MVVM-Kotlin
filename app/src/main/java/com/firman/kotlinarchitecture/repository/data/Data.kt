package com.firman.kotlinarchitecture.repository.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by firman on 01/03/18.
 */
@Entity(tableName = "users")
data class User(
        @PrimaryKey
        @ColumnInfo(name = "email")
        val email: String,
        @ColumnInfo(name = "firstName")
        val first: String,
        @ColumnInfo(name = "lastname")
        val last: String
)