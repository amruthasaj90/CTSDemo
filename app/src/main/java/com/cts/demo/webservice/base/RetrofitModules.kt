package com.cts.demo.webservice.base

import android.content.Context
import com.cts.demo.common.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

const val TIMEOUT_LENGTH: Long = 100

object RetrofitModules {
    private lateinit var retrofitBuilder: Retrofit
    fun init(context: Context) {
        retrofitBuilder = Retrofit.Builder()
            .baseUrl(
                BaseUrlMapping.getUrl(
                    Feature.LiveUrl
                )
            )
            .client(createClient())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create()) /*Use can mention your desired parser over here.!*/
            .build()
    }

    private fun createClient(): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()

        val logging =
            getPrintLogger()
        clientBuilder.interceptors().add(logging)

        //clientBuilder.interceptors().add(UserAgentInterceptor(USER_AGENT))

        clientBuilder.connectTimeout(TIMEOUT_LENGTH, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_LENGTH, TimeUnit.SECONDS)
            .addInterceptor {
                val original = it.request()
                var request: Request?
                    request = original.newBuilder()
                        .header(Constants.ApiHeaderKey.ACCEPT, "application/json")
                        .header(Constants.ApiHeaderKey.CONTENT_TYPE, "application/json")
                        .method(original.method(), original.body())
                        .build()

                it.proceed(request)
            }

        return clientBuilder.build()
    }

    private fun getPrintLogger(): HttpLoggingInterceptor =
        HttpLoggingInterceptor {
            val isJson = it.startsWith("{")

            if (!isJson) {
                return@HttpLoggingInterceptor
            }


        }.setLevel(HttpLoggingInterceptor.Level.BODY)

    fun getRetrofitBuilder(): Retrofit {
        return retrofitBuilder
    }

}
