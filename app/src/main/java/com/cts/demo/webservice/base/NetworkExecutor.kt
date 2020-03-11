package com.cts.demo.webservice.base

import android.content.Context
import com.cts.demo.model.ErrorResponse
import com.cts.demo.utils.isNetworkActive
import com.cts.demo.utils.moshiStringToObj
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.ConnectException
import kotlin.coroutines.resume


suspend fun <T : Any> Call<T>.awaitResult(context: Context? = null): NetworkResult<T> {
    return suspendCancellableCoroutine { continuation ->
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                continuation.resume(
                    if (response.isSuccessful) {
                        val body = response.body()
                        if (body == null) {
                            if (response.errorBody() != null) {
                                NetworkResult.Failed
                            } else {
                                NetworkResult.SuccessfulEmpty
                            }
                        } else {
                            NetworkResult.Successful(
                                body
                            )
                        }
                    } else {
                        when (response.code()) {
                            401 -> NetworkResult.Unauthorized
                            else -> NetworkResult.Failed
                        }
                    })
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                if (continuation.isCancelled) return

                if (isNetworkActive(context)) {
                    continuation.resume(NetworkResult.NoConnectionFailure)
                    return
                }
                continuation.resume(NetworkResult.None)
            }
        })

        registerOnCompletion(continuation)
    }
}

suspend fun <T : Any> Deferred<Response<T>>.awaitResult(): NetworkResult<T> {
    try {
        val response = await()

        return if (response.isSuccessful) {
            val body = response.body()
            if (body == null) {
                if (response.errorBody() != null) {
                    NetworkResult.Failed
                } else {
                    NetworkResult.SuccessfulEmpty
                }
            } else {
                NetworkResult.Successful(body)
            }
        } else {
            when (response.code()) {
//                401 -> NetworkResult.Unauthorized
                400,401, 403, 404 -> {
                    val errorBody = response.errorBody()
                    if (errorBody == null) {
                        NetworkResult.Failed
                    } else {
                        val error = errorBody.string()
                        val errorResponse =error.moshiStringToObj(ErrorResponse::class.java)!!
                        NetworkResult.Error(
                            errorResponse as T
                        )
                    }
                }
                else -> NetworkResult.Failed
            }
        }
    } catch (e: ConnectException) {
        return NetworkResult.NoConnectionFailure
    } catch (e: Exception) {
        return NetworkResult.NoConnectionFailure
    }
}

private fun Call<*>.registerOnCompletion(continuation: CancellableContinuation<*>) {
    continuation.invokeOnCancellation {
        try {
            cancel()
        } catch (ex: Throwable) {
            //Ignore cancel exception
        }
    }
}

sealed class NetworkResult<out T : Any> {
    data class Successful<out T : Any>(val value: T) : NetworkResult<T>()
    data class Malformed<out T : Any>(val value: T) : NetworkResult<T>()
    data class Error<out T : Any>(val value: T) : NetworkResult<T>()
    object SuccessfulEmpty : NetworkResult<Nothing>()
    object None : NetworkResult<Nothing>()
    object Failed : NetworkResult<Nothing>()
    object NoConnectionFailure : NetworkResult<Nothing>()
    object Unauthorized : NetworkResult<Nothing>()
}

/*
sealed class ResponseResult<out T : Any> {
    data class Success<out T : Any>(val value: T) : ResponseResult<T>()
    data class Error<out T : Any>(val value: T) : ResponseResult<T>()
    object NoConnectionFailure : ResponseResult<Nothing>()
    object Unauthorized : ResponseResult<Nothing>()
}
*/

/*
fun generalMappedResponse(result: NetworkResult<Any>): ResponseResult<Any> =
    when(result) {
        is NetworkResult.Unauthorized -> ResponseResult.Unauthorized
        is NetworkResult.NoConnectionFailure -> ResponseResult.NoConnectionFailure
        else -> ResponseResult.Error(result)
    }*/
