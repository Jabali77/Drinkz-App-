package com.vijanaweusi.model.api

import com.vijanaweusi.model.response.CockTailsCategoryResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class CockTailsWebService {

    private lateinit var api: CockTailsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(CockTailsApi::class.java)

    }

    suspend fun getCockTails(): CockTailsCategoryResponse {
        return api.getCockTails()

    }

    interface CockTailsApi {
        @GET("search.php?f=a")
        suspend fun getCockTails(): CockTailsCategoryResponse
    }



}
