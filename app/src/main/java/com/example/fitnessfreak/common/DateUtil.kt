package com.example.fitnessfreak.common

import com.example.fitnessfreak.weightworkout.models.WeightWorkout
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DateUtil {
    companion object {
        fun getCurrentDate(): String {
            val calendar = Calendar.getInstance()
            return SimpleDateFormat(
                WeightWorkout.DATE_FORMAT,
                Locale.getDefault()
            ).format(calendar.time)
        }
    }
}