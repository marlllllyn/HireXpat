package com.jer.hirexpat.api


import com.jer.hirexpat.response.JobJobResponse
import com.jer.hirexpat.response.JobResponse

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//const val BASE_URL = "https://www.freetogame.com/api/"
//const val BASE_URL = "https://project-capstone-hirexpat.ue.r.appspot.com/"
const val param : String = "description"

interface ApiService2 {

    @GET("listjob")
    fun getGames(@Query(param) parameter: String)
    : Call<JobJobResponse>
//    : List<JobResponse>

    @GET("listjob")
    fun getGames2(@Query(param) parameter: String)
    : Call<JobResponse>



}



