package com.example.fitnessfreak.weightworkout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessfreak.databinding.ExerciseItemBinding
import com.example.fitnessfreak.weightworkout.models.WeightExercise

class ExerciseAdapter(private val exercises: MutableList<WeightExercise>) :
    RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    class ExerciseViewHolder(private val binding: ExerciseItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(exercise: WeightExercise) {
            binding.exercise = exercise
            binding.setsList.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                adapter = SetAdapter(exercise.sets)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        return ExerciseViewHolder(
            ExerciseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = exercises.size

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.bind(exercises[position])
    }

    fun setExercises(exercises: List<WeightExercise>) {
        this.exercises.clear()
        this.exercises.addAll(exercises)
        notifyDataSetChanged()
    }
}