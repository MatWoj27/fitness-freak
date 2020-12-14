package com.example.fitnessfreak.weightworkout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessfreak.R
import com.example.fitnessfreak.weightworkout.models.WeightExercise

class ExerciseAdapter(private val exercises: MutableList<WeightExercise>) :
    RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // TODO: use data binding when the item view is ready\
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        return ExerciseViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.exercise_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = exercises.size

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        // TODO: bind data to the views when the item view is ready
    }
}