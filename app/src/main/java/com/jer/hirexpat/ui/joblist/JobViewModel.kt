package com.jer.hirexpat.ui.joblist

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.jer.hirexpat.api.ApiService2
import com.jer.hirexpat.api.RetrofitClient

import com.jer.hirexpat.data.JobRepository
import com.jer.hirexpat.model.JobList

import com.jer.hirexpat.response.JobJobResponse
import com.jer.hirexpat.response.JobResponse

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JobViewModel(
    private val repository: JobRepository
) : ViewModel() {

    private val _sortedJob = MutableStateFlow(
        repository.getJob()
            .sortedBy { it.jobTitle}
            .groupBy { it.jobTitle[0] }
    )


    val sortedJob: StateFlow<Map<Char, List<JobList>>> get() = _sortedJob

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _sortedJob.value = repository.searchJob(_query.value)
            .sortedBy { it.jobTitle }
            .groupBy { it.jobTitle[0] }
    }

//   =============== Dibawah Ini untuk data dr api =================



    private val _listListan = mutableStateListOf<JobResponse>()
    val listListan : List<JobResponse> get() = _listListan









    fun getGameList() {
        val param = "finance"
        val client = RetrofitClient.getApiService(ApiService2::class.java).getGames(param)

        client.enqueue(object : Callback<JobJobResponse> {
//
            override fun onResponse(call: Call<JobJobResponse>, response: Response<JobJobResponse>) {
                if (response.isSuccessful) {
                    val jobResponseList: List<JobResponse>? = response.body()?.list_job



                    _listListan.clear()

                    if (jobResponseList != null) {
                        _listListan.addAll(
//                            listOf(jobResponseList)
                            jobResponseList
                        )
                    }

                } else {
                    Log.e("JobViewModel", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<JobJobResponse>, t: Throwable) {
                Log.e("JobViewModel", "onFailure: ${t.message}")
            }
        })
    }


}