package com.fintechhub.tweety.api

import com.fintechhub.tweety.model.TweetyDataItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyApi {
    @GET("/v3/b/670e009ead19ca34f8b8b14b?meta=false")
    suspend fun getTweetsy(@Header("X-JSON-Path") category: String) : Response<List<TweetyDataItem>>

    @GET("/v3/b/670e009ead19ca34f8b8b14b?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategories(): Response<List<String>>

}