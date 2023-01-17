package com.saadahmedsoft.fakestoreapp.services.repository

import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class AppRepo {

    private fun getErrorMessage(byteStream: InputStream): String {
        val reader: BufferedReader
        val sb = StringBuilder()
        try {
            reader =
                BufferedReader(InputStreamReader(byteStream))
            var line: String?
            try {
                while (reader.readLine().also { line = it } != null) {
                    sb.append(line)
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return JSONObject(sb.toString()).getString("message")
    }
}