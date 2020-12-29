package com.example.fitnessfreak.weightworkout

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.fitnessfreak.common.DateUtil
import com.example.fitnessfreak.weightworkout.models.WeightExercise
import com.example.fitnessfreak.weightworkout.models.WeightSet
import com.example.fitnessfreak.weightworkout.models.WeightWorkout
import java.util.concurrent.Executors

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
                        )
                            .addCallback(populateForTestingCallback)
                            .build()
                    }
                }
            }
            return instance!!
        }

        private val populateForTestingCallback = object : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                Executors.newSingleThreadScheduledExecutor().execute {
                    val exercises = listOf(
                        WeightExercise(
                            "Bench press", listOf(
                                WeightSet(100, 8), WeightSet(100, 8), WeightSet(100, 8)
                            )
                        ),
                        WeightExercise(
                            "Dead Lift", listOf(
                                WeightSet(120, 8), WeightSet(120, 8), WeightSet(120, 8)
                            )
                        )
                    )
                    instance?.apply {
                        getWeightWorkoutDao().insert(
                            WeightWorkout(
                                0,
                                "Push Volume",
                                DateUtil.getCurrentDate(),
                                exercises
                            )
                        )
                    }
                }
            }
        }
    }
}