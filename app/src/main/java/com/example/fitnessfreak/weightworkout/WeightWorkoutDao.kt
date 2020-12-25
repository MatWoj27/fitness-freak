package com.example.fitnessfreak.weightworkout

import androidx.room.Dao
import androidx.room.Insert
import com.example.fitnessfreak.weightworkout.models.WeightWorkout

@Dao
interface WeightWorkoutDao {
    @Insert
    fun insert(weightWorkout: WeightWorkout)
}