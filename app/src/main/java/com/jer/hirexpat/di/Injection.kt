package com.jer.hirexpat.di

import com.jer.hirexpat.api.ApiService2
import com.jer.hirexpat.api.RetrofitClient
import com.jer.hirexpat.data.JobRepository

object Injection {

    fun provideRepository(): JobRepository {
//        val apiService2  = ApiService2
        val apiService2 = RetrofitClient.getApiService(ApiService2::class.java)

        return JobRepository.getInstance()
    }
}