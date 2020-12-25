package com.example.fitnessfreak.weightworkout

import androidx.room.TypeConverter
import com.example.fitnessfreak.weightworkout.models.WeightExercise
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class WeightWorkoutTypeConverters {
    @TypeConverter
    fun weightExerciseListToString(exercises: List<WeightExercise>): String =
        Gson().toJson(exercises)

    @TypeConverter
    fun stringToWeightExerciseList(data: String): List<WeightExercise> {
        val type = object : TypeToken<List<WeightExercise>>() {}.type
        return Gson().fromJson(data, type)
    }
}