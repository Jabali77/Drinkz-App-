package com.vijanaweusi

import com.vijanaweusi.model.api.CockTailsWebService
import com.vijanaweusi.model.response.CockTailsCategoryResponse

class CockTailsRepository (private val webService: CockTailsWebService = CockTailsWebService()) {

    suspend fun getCockTails(): CockTailsCategoryResponse {
        return webService.getCockTails()
    }
}