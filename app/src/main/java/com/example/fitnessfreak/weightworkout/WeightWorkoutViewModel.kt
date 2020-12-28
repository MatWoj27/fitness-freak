package com.example.fitnessfreak.weightworkout

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.fitnessfreak.DateUtil
import com.example.fitnessfreak.weightworkout.models.WeightWorkout

class WeightWorkoutViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = WorkoutRepository(application)
    private var currentDate: String = DateUtil.getCurrentDate()

    private var weightWorkoutLiveData: MutableLiveData<WeightWorkout>? = null

    fun getWeightWorkoutLiveData() =
        Transformations.switchMap(repository.getWeightWorkoutByDate(currentDate)) {
            if (weightWorkoutLiveData == null) {
                weightWorkoutLiveData = MutableLiveData(it)
            } else {
                weightWorkoutLiveData!!.value = it
            }
            weightWorkoutLiveData
        }
}