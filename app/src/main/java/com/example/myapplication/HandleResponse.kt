package com.example.myapplication


class HandleResponse(private val jsonDataResponse: JsonDataResponse) {

    fun handle(){
          val singleType=jsonDataResponse.signalType;
          when (singleType)
           {
             SocketRequest.ACT.value ->{
                 handleACT()
             }

           }
    }
    private fun handleACT(){}
}