package com.cts.demo.webservice

import com.cts.demo.webservice.base.NetworkResult
import com.cts.demo.webservice.base.RetrofitModules
import com.cts.demo.webservice.base.awaitResult

class FactsApi {


    suspend fun getFactsList(): NetworkResult<Any> {
        val apiService = RetrofitModules.getRetrofitBuilder().create(
            ApiInterface::class.java
        )
        return apiService.getFactsList().awaitResult()
    }


}