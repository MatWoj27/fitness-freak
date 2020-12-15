package com.example.fitnessfreak.weightworkout

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.fitnessfreak.weightworkout.models.WeightWorkout

class WeightWorkoutViewModel(application: Application) : AndroidViewModel(application) {
    var weightWorkoutLiveData: LiveData<WeightWorkout>? = null
}