package com.firman.kotlinarchitecture.viewmodel

import com.firman.kotlinarchitecture.repository.UserRepository
import com.firman.kotlinarchitecture.viewmodel.data.UsersList
import io.reactivex.Observable
import timber.log.Timber
import java.util.concurrent.TimeUnit

/**
 * Created by firman on 01/03/18.
 */
class UserListViewModel(private val userRepository: UserRepository) {
    fun getUsers(): Observable<UsersList> {
        return userRepository.getUsers()
                .debounce(400, TimeUnit.MILLISECONDS)
                .map {
                    Timber.d("Mapping users to UIData...")
                    UsersList(it.take(10), "Top 10 Users")
                }
                .onErrorReturn {
                    UsersList(emptyList(), "An error occured", it)
                }
    }

}