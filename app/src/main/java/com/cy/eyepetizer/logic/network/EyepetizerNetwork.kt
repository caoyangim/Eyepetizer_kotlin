package com.cy.eyepetizer.logic.network

import com.cy.applibrary.network.ServiceCreator
import com.cy.eyepetizer.logic.network.api.MainPageService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class EyepetizerNetwork {

    private val mainPageService = ServiceCreator.create(MainPageService::class.java)

    suspend fun fetchHomePageRecommend(url: String) = mainPageService.getHomePageRecommend(url).await()
    suspend fun fetchDaily(url:String) = mainPageService.getDaily(url).await()
    suspend fun fetchDiscover(url:String) = mainPageService.getDiscover(url).await()

    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }
            })
        }
    }

    companion object {

        private var network: EyepetizerNetwork? = null

        fun getInstance(): EyepetizerNetwork {
            if (network == null) {
                synchronized(EyepetizerNetwork::class.java) {
                    if (network == null) {
                        network = EyepetizerNetwork()
                    }
                }
            }
            return network!!
        }
    }
}