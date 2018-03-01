package com.firman.kotlinarchitecture.repository.api

import com.firman.kotlinarchitecture.repository.data.User
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by firman on 01/03/18.
 */
interface UserApi {

    @GET("6de6abfedb24f889e0b5f675edc50deb?fmt=raw&sole")
    fun getUsers(): Observable<List<User>>
}
