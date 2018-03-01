package com.firman.kotlinarchitecture.repository

import com.firman.kotlinarchitecture.repository.api.UserApi
import com.firman.kotlinarchitecture.repository.data.User
import com.firman.kotlinarchitecture.repository.db.UserDao
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


/**
 * Created by firman on 01/03/18.
 */
class UserRepository(private val userApi: UserApi, private val userDao: UserDao) {

    fun getUsers(): Observable<List<User>> {
        return Observable.concatArray(
                getUsersFromDb(),
                getUsersFromApi())
    }

    private fun getUsersFromApi(): Observable<List<User>> {
        return userApi.getUsers()
                .doOnNext {
                    Timber.d("Dispatching ${it.size} users from API...")
                    storeUserinDb(it)
                }
    }

    private fun storeUserinDb(users: List<User>) {
        Observable.fromCallable { userDao.insertAll(users) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe{
                    Timber.d("Inserted ${users.size} users from API in DB...")
                }
    }

    private fun getUsersFromDb(): Observable<List<User>> {
        return userDao.getUsers().filter{ it.isNotEmpty() }
                .toObservable()
                .doOnNext {
                    Timber.d("Dispatching${it.size} users from DB..." )
                }
    }
}