package com.example.myapplication

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStream
import java.net.Socket

class ClientHandler (client: Socket) {
    private val client: Socket = client
    val input = BufferedReader(InputStreamReader(client.inputStream))
    private val writer: OutputStream = client.getOutputStream()
    private var running = false


    fun run() {
        Log.e("test","test")
        Log.e("read","${input.readLine()} ")
        write("hello from server")

        }

    private fun write(message: String) {
        writer.write((message + '\n').toByteArray())
        writer.flush()
    }

    private fun shutdown() {
        running = false
        client.close()
    }
}