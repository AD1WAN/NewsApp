package com.example.aadknewsapp

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    suspend fun fetchHeadLines(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apikey") apiKey: String
    ) :News



}