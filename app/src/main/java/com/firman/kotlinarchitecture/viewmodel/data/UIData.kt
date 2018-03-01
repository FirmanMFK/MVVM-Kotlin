package com.firman.kotlinarchitecture.viewmodel.data

import com.firman.kotlinarchitecture.repository.data.User

/**
 * Created by firman on 01/03/18.
 */
data class UsersList(val users: List<User>, val message: String, val error: Throwable? = null)