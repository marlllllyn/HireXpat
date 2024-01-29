package com.jer.hirexpat.response

data class Job(
    val ID_company: Int,
    val country: String,
    val description: String,
    val email: String,
    val industry: String,
    val name: String,
    val position_available: String,
    val provinces: String
)