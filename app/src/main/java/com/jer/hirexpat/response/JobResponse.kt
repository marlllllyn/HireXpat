package com.jer.hirexpat.response

data class JobResponse(
    val ID_company: Long,
    val position_available: String,
    val name: String,
    val description: String,
//    val provinces: String,
//    val country: String,
//    val email: String,
//    val industry: String,
)


data class JobJobResponse(
    val list_job: List<JobResponse>,
    val prediction: String
)