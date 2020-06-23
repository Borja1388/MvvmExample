package com.example.remote

import com.example.common.models.FactBo
import com.example.remote.models.toBo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FactRepository() {
    private val service : FactsService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://cat-fact.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(FactsService::class.java)
    }

    suspend fun getRandomFact() : FactBo{
        return service.getRandomFacts().toBo()
    }

}