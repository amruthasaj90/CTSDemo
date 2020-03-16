package com.cts.demo.ui.facts

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cts.demo.base.BaseViewModel
import com.cts.demo.utils.CodeSnippetExtension
import com.cts.demo.webservice.base.NetworkResult
import kotlinx.coroutines.launch

class FactsViewModel : BaseViewModel() {

    val factsList = MutableLiveData<NetworkResult<Any>?>()
    override fun onCreate(bundle: Bundle?) {
        getFactsList()
    }

    private val factsRepository: FactsRepository by lazy {
        FactsRepository(
            CodeSnippetExtension.getInstance()
        )
    }

    fun getFactsList() {
        viewModelScope.launch {
            factsRepository.getFactsList(factsList)
        }
    }
}