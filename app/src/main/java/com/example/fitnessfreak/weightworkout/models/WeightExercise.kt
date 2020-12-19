package com.example.fitnessfreak.weightworkout.models

import android.content.Context
import com.example.fitnessfreak.R

data class WeightExercise(
    val name: String,
    val sets: List<WeightSet>
) {
    fun getExerciseVolume() = sets.sumBy { weightSet ->
        weightSet.reps * weightSet.weight
    }

    fun getSetsColumnText(context: Context): String {
        val setsString = context.getString(R.string.sets)
        return if (sets.isNotEmpty()) {
            "${sets.size} ${setsString.toLowerCase()}"
        } else {
            setsString
        }
    }
}

data class WeightSet(
    val weight: Int,
    val reps: Int
)