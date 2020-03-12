package com.cts.demo.webservice

import com.cts.demo.model.response.FactsResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @POST("/s/2iodh4vg0eortkl/facts.json")
    fun getFactsList(): Deferred<Response<FactsResponse>>

}