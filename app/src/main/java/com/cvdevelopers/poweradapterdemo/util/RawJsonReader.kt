package com.cvdevelopers.poweradapterdemo.util

import android.app.Application
import java.nio.charset.Charset
import javax.inject.Inject

class RawJsonReader  @Inject constructor (private val application: Application) {

    fun readJson(resourceId: Int): String {
        val inputStream = application.resources.openRawResource(resourceId)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        return String(buffer, Charset.forName("UTF-8"))
    }
}