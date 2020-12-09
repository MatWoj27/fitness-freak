package com.example.fitnessfreak.weightworkout.models

data class WeightExercise(
    val name: String,
    val sets: List<WeightSet>
)

data class WeightSet(
    val weight: Int,
    val reps: Int
)