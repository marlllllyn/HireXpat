package com.jer.hirexpat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jer.hirexpat.data.JobRepository
import com.jer.hirexpat.ui.detailjob.DetailViewModel
import com.jer.hirexpat.ui.joblist.JobViewModel

class ViewModelFactory (private val repository: JobRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JobViewModel::class.java)) {
            return JobViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

}