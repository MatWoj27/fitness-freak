package com.example.fitnessfreak.weightworkout

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.fitnessfreak.common.DateUtil
import com.example.fitnessfreak.common.TextViewAnimation
import com.example.fitnessfreak.weightworkout.models.WeightWorkout
import java.text.SimpleDateFormat
import java.util.Locale

class WeightWorkoutViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = WorkoutRepository(application)
    private var currentDateLiveData =
        MutableLiveData<Pair<String, TextViewAnimation>>(
            Pair(
                DateUtil.getCurrentDate(WeightWorkout.DATE_FORMAT),
                TextViewAnimation.NO_ANIMATION
            )
        )
    private var weightWorkoutLiveData: MutableLiveData<WeightWorkout>? = null

    fun getWeightWorkoutLiveData(): LiveData<WeightWorkout?> =
        Transformations.switchMap(currentDateLiveData) {
            Transformations.map(repository.getWeightWorkoutByDate(it.first)) { workout ->
                if (weightWorkoutLiveData == null) {
                    weightWorkoutLiveData = MutableLiveData(workout)
                } else {
                    weightWorkoutLiveData!!.apply { value = workout }
                }
                workout
            }
        }

    fun getDisplayDateLiveData() = Transformations.map(currentDateLiveData) {
        val dateFormat = SimpleDateFormat(WeightWorkout.DATE_FORMAT, Locale.getDefault())
        val date = dateFormat.parse(it.first)
        Pair(
            dateFormat.apply {
                applyPattern(DISPLAY_DATE_FORMAT)
            }.format(date),
            it.second
        )
    }

    fun nextDate() = currentDateLiveData.value?.let {
        currentDateLiveData.value = Pair(
            DateUtil.getNextDate(
                it.first,
                WeightWorkout.DATE_FORMAT,
                WeightWorkout.DATE_FORMAT
            ),
            TextViewAnimation.SWIPE_RTL
        )
    }

    fun previousDate() = currentDateLiveData.value?.let {
        currentDateLiveData.value = Pair(
            DateUtil.getPreviousDate(
                it.first,
                WeightWorkout.DATE_FORMAT,
                WeightWorkout.DATE_FORMAT
            ),
            TextViewAnimation.SWIPE_LTR
        )
    }

    companion object {
        const val DISPLAY_DATE_FORMAT = "dd-MM-yyyy"
    }
}