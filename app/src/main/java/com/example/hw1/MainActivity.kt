package com.example.hw1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hw1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var counter = 0
    private val constSeatingCapacity = 49
    private val constAllSeatsAreAvailable = "Все места свободны"
    private val constRemainingPlaces = "Осталось мест: "
    private val constTooManyPassengers = "Пассажиров слишком много!"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = constAllSeatsAreAvailable
        binding.textView.setTextColor(Color.GREEN)
        binding.button.visibility = View.INVISIBLE
        binding.minusButton.isEnabled = false

        binding.plusButton.setOnClickListener {
            counter++
            binding.minusButton.isEnabled = counter > 0
            if(counter <= constSeatingCapacity) {
                binding.textView.text = constRemainingPlaces + (constSeatingCapacity - counter).toString()
                binding.textView.setTextColor(Color.BLUE)
            } else {
                binding.textView.text = constTooManyPassengers
                binding.textView.setTextColor(Color.RED)
            }
            if(counter >= constSeatingCapacity + 1) {
                binding.button.visibility = View.VISIBLE
            } else {
                binding.button.visibility = View.INVISIBLE
            }
            binding.textViewCount.text = counter.toString()
        }

        binding.minusButton.setOnClickListener {
            if(counter > 0) {
                counter--
                if(counter <= constSeatingCapacity) {
                    binding.textView.text = constRemainingPlaces + (constSeatingCapacity - counter).toString()
                    binding.textView.setTextColor(Color.BLUE)
                } else {
                    binding.textView.text = constTooManyPassengers
                    binding.textView.setTextColor(Color.RED)
                }
                if(counter >= constSeatingCapacity + 1) {
                    binding.button.visibility = View.VISIBLE
                } else {
                    binding.button.visibility = View.INVISIBLE
                }
                binding.textViewCount.text = counter.toString()
            }
            if(counter == 0) {
                binding.minusButton.isEnabled = false
                binding.textView.text = constAllSeatsAreAvailable
                binding.textView.setTextColor(Color.GREEN)
            }
        }

        binding.button.setOnClickListener {
            counter = 0;
            binding.textView.text = constAllSeatsAreAvailable
            binding.textView.setTextColor(Color.GREEN)
            binding.button.visibility = View.INVISIBLE
            binding.minusButton.isEnabled = false
            binding.textViewCount.text = counter.toString()
        }
    }
}