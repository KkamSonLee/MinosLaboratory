package com.angdroid.minoslaboratory.data.api

import com.angdroid.minoslaboratory.data.dto.MyData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LocalHostApi {
    @GET("/")
    suspend fun getHelloWorld(): String

    @GET("/api/message")
    suspend fun getMessage(): MyData

    @POST("/api/message")
    suspend fun postMessage(@Body message: MyData): MyData

}