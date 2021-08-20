package com.example.myapplication

import android.util.Log
import java.io.OutputStream
import java.net.Socket


class ClientHandler (client: Socket) {
    private val client: Socket = client
    private val writer: OutputStream = client.getOutputStream()
    private var running = false

    fun run() {
        var jsonRequest =readfromSocket()
        Log.e("asd",jsonRequest)
        val x=  HandleResponse.handleRequest(jsonRequest)
        write(x)
        }

    fun readfromSocket():String {
        val sb = StringBuilder()
        var c: Int
        while (client.getInputStream().read().also { c = it } >= 0 && c != 0x0a /* <LF> */) {
            if (c != 0x0d /* <CR> */) {
                sb.append(c.toChar())
            }
            if (client.getInputStream().available()==0)
            {
                return sb.toString()
            }

        }

        return sb.toString()
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