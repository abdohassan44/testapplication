package com.example.myapplication

import kotlinx.serialization.Serializable

@Serializable
data class SignalData(
    val id: String? = "",
    val value: String? = ""
)
