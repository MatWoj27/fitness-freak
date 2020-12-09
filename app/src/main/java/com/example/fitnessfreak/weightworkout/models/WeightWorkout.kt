package com.example.fitnessfreak.weightworkout.models

data class WeightWorkout(
    val name: String,
    val date: String,
    val exercises: List<WeightExercise>
)