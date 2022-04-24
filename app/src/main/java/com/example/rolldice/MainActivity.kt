package com.example.rolldice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.rolldice.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding
class Dice (val num: Int) {
    fun roll(): Int {
        return (1..num).random()
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        rollDice()
        binding.rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
        val setImage = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.imageView.setImageResource(setImage)
        binding.imageView.contentDescription = diceRoll.toString()
    }
}