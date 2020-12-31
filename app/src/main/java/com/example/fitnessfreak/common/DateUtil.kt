package com.example.fitnessfreak.common

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DateUtil {
    companion object {
        fun getCurrentDate(pattern: String): String {
            val calendar = Calendar.getInstance()
            return SimpleDateFormat(
                pattern,
                Locale.getDefault()
            ).format(calendar.time)
        }
    }
}