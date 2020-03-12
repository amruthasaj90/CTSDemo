package com.cts.demo.ui.facts

import androidx.lifecycle.MutableLiveData
import com.cts.demo.utils.CodeSnippetExtension
import com.cts.demo.webservice.FactsApi
import com.cts.demo.webservice.base.NetworkResult
import kotlinx.coroutines.*


class FactsRepository(codeSnippet: CodeSnippetExtension) {
    private val codeSnippetExt: CodeSnippetExtension = codeSnippet
    private val uiDispatcher: CoroutineDispatcher = Dispatchers.IO
    private val factsApi: FactsApi by lazy { FactsApi() }
    suspend fun getFactsList(response: MutableLiveData<NetworkResult<Any>?>) {
        GlobalScope.launch(uiDispatcher)
        {
            async {
                if (codeSnippetExt.isNetworkActive()) {
                    response.postValue(factsApi.getFactsList())
                } else {
                    response.postValue(NetworkResult.NoConnectionFailure)
                }
            }
        }
    }
}