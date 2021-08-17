package com.example.myapplication

data class JsonDataResponse(
    val signalData: List<SignalData>? = listOf(),
    val signalType: String? = "",
)
data class SignalData(
    val  id: String? = "",
    val value: String? = ""
)