package com.mtp.kotlin.demokotlin.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Sofien on 03/06/2018.
 */
object DateUtils {
    @JvmStatic
    fun toSimpleString(date: String) : String {
        val dateTime = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(date);
        return dateTime.toString()
    }
}