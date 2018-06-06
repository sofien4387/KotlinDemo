package com.mtp.kotlin.demokotlin.app

import com.mtp.kotlin.demokotlin.mvp.models.model.Nasa
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface PostApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("/planetary/apod?api_key=DEMO_KEY&count=5")
    fun getPosts(): Observable<List<Nasa>>
}