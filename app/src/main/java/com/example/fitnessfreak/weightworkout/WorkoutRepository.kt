package com.example.fitnessfreak.weightworkout

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.fitnessfreak.weightworkout.models.WeightWorkout

class WorkoutRepository(context: Context) {
    private val weightWorkoutDao = WorkoutDatabase.getInstance(context).getWeightWorkoutDao()

    fun getWeightWorkoutByDate(date: String): LiveData<WeightWorkout> =
        weightWorkoutDao.getWorkoutByDate(date)
}