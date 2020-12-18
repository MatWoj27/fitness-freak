package com.example.fitnessfreak.weightworkout.models

data class WeightExercise(
    val name: String,
    val sets: List<WeightSet>
) {
    fun getExerciseVolume() = sets.sumBy { weightSet ->
        weightSet.reps * weightSet.weight
    }
}

data class WeightSet(
    val weight: Int,
    val reps: Int
)