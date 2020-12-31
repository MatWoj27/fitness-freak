package com.example.fitnessfreak.weightworkout

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.fitnessfreak.common.DateUtil
import com.example.fitnessfreak.weightworkout.models.WeightWorkout
import java.text.SimpleDateFormat
import java.util.Locale

class WeightWorkoutViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = WorkoutRepository(application)
    private var currentDateLiveData =
        MutableLiveData<String>(DateUtil.getCurrentDate(WeightWorkout.DATE_FORMAT))
    private var weightWorkoutLiveData: MutableLiveData<WeightWorkout>? = null

    fun getWeightWorkoutLiveData(): LiveData<WeightWorkout?> =
        Transformations.switchMap(repository.getWeightWorkoutByDate(currentDateLiveData.value!!)) {
            if (weightWorkoutLiveData == null) {
                weightWorkoutLiveData = MutableLiveData(it)
            } else {
                weightWorkoutLiveData!!.value = it
            }
            weightWorkoutLiveData
        }

    fun getDisplayDateLiveData() = Transformations.map(currentDateLiveData) {
        val dateFormat = SimpleDateFormat(WeightWorkout.DATE_FORMAT, Locale.getDefault())
        val date = dateFormat.parse(it)
        dateFormat.apply {
            applyPattern(DISPLAY_DATE_FORMAT)
        }.format(date)
    }

    companion object {
        const val DISPLAY_DATE_FORMAT = "dd-MM-yyyy"
    }
}