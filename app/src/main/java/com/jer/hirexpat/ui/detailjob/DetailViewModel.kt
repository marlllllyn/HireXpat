package com.jer.hirexpat.ui.detailjob

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jer.hirexpat.api.ApiService2
import com.jer.hirexpat.api.RetrofitClient
import com.jer.hirexpat.data.JobRepository
import com.jer.hirexpat.model.Job
import com.jer.hirexpat.response.JobJobResponse
import com.jer.hirexpat.response.JobResponse

import com.jer.hirexpat.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel(private val repository: JobRepository) : ViewModel() {


    // Ini untuk data dummy

//    private val _uiState: MutableStateFlow<UiState<Job>> =
//        MutableStateFlow(UiState.Loading)
//    val uiState: StateFlow<UiState<Job>>
//        get() = _uiState


    private val _uiState2: MutableStateFlow<UiState<JobResponse>> =
        MutableStateFlow(UiState.Loading)
    val uiState2: StateFlow<UiState<JobResponse>>
        get() = _uiState2

//    ini utuk data dummy
//    fun getRewardById(rewardId: Long) {
//        viewModelScope.launch {
//            _uiState.value = UiState.Loading
//            _uiState.value = UiState.Success(repository.getJobDetail(rewardId))
//        }
//    }



    fun getRewardById2() {
        val param = "finance"
        val client = RetrofitClient.getApiService(ApiService2::class.java).getGames2(param)

        client.enqueue(object : Callback<JobResponse> {


            override fun onResponse(call: Call<JobResponse>, response: Response<JobResponse>) {
                if (response.isSuccessful) {




                    val jobResponse: JobResponse? = response.body()

                    if (jobResponse != null) {
                        // Perbarui StateFlow dengan respons yang berhasil
                        _uiState2.value = UiState.Success(jobResponse)
                    }
                    else {
                        Log.e("DetailViewModel", "onFailure: ${response.message()}")
                    }
                } else {
                    // Jika respons tidak berhasil, perbarui StateFlow dengan UiState.Error
                    _uiState2.value = UiState.Error(response.message())
                }
            }

            override fun onFailure(call: Call<JobResponse>, t: Throwable) {
                Log.e("JobViewModel", "onFailure: ${t.message}")
            }
        })
    }


}