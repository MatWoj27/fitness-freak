package com.example.fitnessfreak.weightworkout

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessfreak.R
import com.example.fitnessfreak.databinding.ExerciseItemBinding
import com.example.fitnessfreak.weightworkout.models.WeightExercise

class ExerciseAdapter(private val exercises: MutableList<WeightExercise>) :
    RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    class ExerciseViewHolder(private val binding: ExerciseItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.exerciseVolume.addTextChangedListener(
                object : TextWatcher {
                    override fun afterTextChanged(p0: Editable?) {}

                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) =
                        resizeVolumeView()
                }
            )
        }

        fun bind(exercise: WeightExercise) {
            binding.exercise = exercise
            binding.setsList.apply {
                layoutManager = LinearLayoutManager(binding.root.context)
                adapter = SetAdapter(exercise.sets)
            }
        }

        private fun resizeVolumeView() {
            binding.exerciseVolume.let {
                it.measure(0, 0)
                val width = it.measuredWidth
                val height = it.measuredHeight
                if (width > height) {
                    it.height = width
                } else {
                    it.width = height
                }
                binding.exerciseVolume.setBackgroundResource(R.drawable.oval_background)
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