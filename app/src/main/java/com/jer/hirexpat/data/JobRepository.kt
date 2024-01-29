package com.jer.hirexpat.data

import android.util.Log
import com.jer.hirexpat.api.ApiService2
import com.jer.hirexpat.api.RetrofitClient
import com.jer.hirexpat.model.Job
import com.jer.hirexpat.model.JobData
import com.jer.hirexpat.model.JobList


class JobRepository() {




//    val apiService2: ApiService2 get() = ApiService2.getInstance()
    val apiService2 = RetrofitClient.getApiService(ApiService2::class.java)


    fun getJob(): List<JobList> {
        return JobData.jobList
    }

    fun searchJob(query: String) : List<JobList> {
        return JobData.jobList.filter {
            it.jobTitle.contains(query, ignoreCase = true)
        }
    }


    fun getJobDetail(jobId: Long) : Job {
        return JobData.job.first{
            it.id == jobId
        }
    }












    companion object {
        @Volatile
        private var instance: JobRepository? = null

        fun getInstance(): JobRepository =
            instance ?: synchronized(this) {
                JobRepository(
//                    apiService2
                ).apply {

                    instance = this
                }
            }
    }
}