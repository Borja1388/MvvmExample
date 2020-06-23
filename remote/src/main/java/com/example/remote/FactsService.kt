package com.example.remote

import com.example.remote.models.FactDto
import retrofit2.http.GET

interface FactsService {
    @GET("/facts/random")
    suspend fun getRandomFacts() : FactDto
}