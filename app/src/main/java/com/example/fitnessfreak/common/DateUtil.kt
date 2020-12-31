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

        fun getNextDate(
            currentDate: String,
            inputPattern: String,
            outputPattern: String
        ): String =
            changeDateOfDays(currentDate, inputPattern, outputPattern, 1)

        fun getPreviousDate(
            currentDate: String,
            inputPattern: String,
            outputPattern: String
        ): String =
            changeDateOfDays(currentDate, inputPattern, outputPattern, -1)

        private fun changeDateOfDays(
            currentDate: String,
            inputPattern: String,
            outputPattern: String,
            shift: Int
        ): String {
            val dateFormat = SimpleDateFormat(inputPattern, Locale.getDefault())
            val date = Calendar.getInstance().apply {
                time = dateFormat.parse(currentDate)
                add(Calendar.DAY_OF_YEAR, shift)
            }.time
            return dateFormat.apply {
                applyPattern(outputPattern)
            }.format(date)
        }
    }
}