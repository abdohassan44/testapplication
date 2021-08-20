package com.example.myapplication

import android.content.*
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.Formatter
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    var SERVER_IP = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        val ipAddress: String = Formatter.formatIpAddress(wifiManager.connectionInfo.ipAddress)
        SERVER_IP = ipAddress
        Log.e("test",SERVER_IP)

        GlobalScope.launch {

            var server = java.net.ServerSocket(5060)
            val client = server.accept()
            ClientHandler(client).run()
        }

    }
}

