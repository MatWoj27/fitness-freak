package com.example.fitnessfreak.weightworkout

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fitnessfreak.weightworkout.models.WeightWorkout

@Dao
interface WeightWorkoutDao {
    @Insert
    fun insert(weightWorkout: WeightWorkout)

    @Query("SELECT * FROM ${WeightWorkout.TABLE_NAME} WHERE ${WeightWorkout.DATE_COLUMN} LIKE :date")
    fun getWorkoutByDate(date: String): LiveData<WeightWorkout>
}