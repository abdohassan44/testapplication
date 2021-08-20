package com.example.myapplication

import android.util.Log
import kotlinx.serialization.*
import kotlinx.serialization.json.*


object  HandleResponse{

    fun handleRequest(jsonStringe: String):String{
        Log.e("asd",jsonStringe)


        val jsonDataResponse = Json.decodeFromString<RequestData>(jsonStringe)


        when (jsonDataResponse.signalType)
           {
             SocketRequest.ACT.value ->{
                 return handleACT(jsonDataResponse)
             }
            SocketRequest.CONFIG.value ->{
                return handleCONFIG(jsonDataResponse)
            }
            SocketRequest.STOP.value ->{
                return  handleSTOP(jsonDataResponse)
            }
            SocketRequest.TEST_INFO .value ->{
                return handleTEST_INFO(jsonDataResponse)
            }

           }
        return "593"
    }

    private fun handleACT(requestData: RequestData): String {

        Log.e("signalType", requestData.signalType.toString())
        for (x in requestData.signalData!!) {
            Log.e("id", x.id.toString())
            Log.e("value", x.value.toString())
        }



        return "{\"signalType\":\"ACT_ACK\", \"signalData\":[\n" +
                "{\"id\":\"ResponseCode\",\"value\":\"YES\"}\n" +
                "]}"
    }

    private fun handleCONFIG(requestData:RequestData):String{
        Log.e("signalType", requestData.signalType.toString())
        for(x in requestData.signalData!!)
        {
            Log.e("id", x.id.toString())
            Log.e("value", x.value.toString())
        }
        return "123"
    }

    private fun handleSTOP(requestData:RequestData):String{
        Log.e("signalType", requestData.signalType.toString())
        for(x in requestData.signalData!!)
        {
            Log.e("id", x.id.toString())
            Log.e("value", x.value.toString())
        }
        return "123"
    }

    private fun handleTEST_INFO(requestData:RequestData):String{
        Log.e("signalType", requestData.signalType.toString())
        for(x in requestData.signalData!!)
        {
            Log.e("id", x.id.toString())
            Log.e("value", x.value.toString())
        }
        return "123"
    }
}