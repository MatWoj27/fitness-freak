package com.example.fitnessfreak.weightworkout.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.fitnessfreak.weightworkout.WeightWorkoutTypeConverters

@TypeConverters(WeightWorkoutTypeConverters::class)
@Entity(tableName = WeightWorkout.TABLE_NAME)
data class WeightWorkout(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    @ColumnInfo(name = DATE_COLUMN)
    val date: String,
    val exercises: List<WeightExercise>
) {
    companion object {
        const val TABLE_NAME = "weight_workouts"
        const val DATE_COLUMN = "date"
        const val DATE_FORMAT = "d-M-yyyy"
    }
}