package com.example.myapplication

import kotlinx.serialization.Serializable

@Serializable
data class RequestData(
    var signalData: List<SignalData>? = listOf(),
    var signalType: String? = "",
)
