package com.umutg.bitaksicaseapp.common

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    @SuppressLint("SimpleDateFormat")
    fun convertTimestampToDate(time: Double): String {

        val sdf = SimpleDateFormat("HH:mm:ss")
        val date = Date((time * 1000).toLong())

        return sdf.format(date)
    }
}
