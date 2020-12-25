package com.example.fitnessfreak.weightworkout

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fitnessfreak.weightworkout.models.WeightWorkout

@Database(entities = [WeightWorkout::class], version = 1)
abstract class WorkoutDatabase : RoomDatabase() {
    abstract fun getWeightWorkoutDao(): WeightWorkoutDao

    companion object {
        private const val DATABASE_NAME = "workout_database"

        @Volatile
        private var instance: WorkoutDatabase? = null

        fun getInstance(context: Context): WorkoutDatabase {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            context,
                            WorkoutDatabase::class.java,
                            DATABASE_NAME
                        ).build()
                    }
                }
            }
            return instance!!
        }
    }
}