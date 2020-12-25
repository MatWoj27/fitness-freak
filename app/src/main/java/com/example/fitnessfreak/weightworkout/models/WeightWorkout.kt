package com.example.fitnessfreak.weightworkout.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.fitnessfreak.weightworkout.WeightWorkoutTypeConverters

@Entity(tableName = WeightWorkout.TABLE_NAME)
data class WeightWorkout(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val date: String,
    @TypeConverters(WeightWorkoutTypeConverters::class)
    val exercises: List<WeightExercise>
) {
    companion object {
        const val TABLE_NAME = "weight_workouts"
    }
}