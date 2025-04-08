package com.example.mymealmateapp2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.`meal-mate`.R

class MainActivity : AppCompatActivity() {

    private lateinit var timeSpinner: Spinner
    private lateinit var mealSpinner: Spinner
    private lateinit var addToCartButton: Button
    private lateinit var cartTextView: TextView
    private lateinit var submitOrderButton: Button
    private lateinit var suggestionTextView: TextView
    private lateinit var resetButton: Button

    private var cartItems: MutableList<String> = mutableListOf()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        timeSpinner = findViewById(R.id.timeSpinner)
        mealSpinner = findViewById(R.id.mealSpinner)
        addToCartButton = findViewById(R.id.addToCartButton)
        cartTextView = findViewById(R.id.cartTextView)
        submitOrderButton = findViewById(R.id.submitOrderButton)
        suggestionTextView = findViewById(R.id.suggestionTextView)
        resetButton = findViewById(R.id.resetButton)

        // Initialize Time Spinner
        val timeOptions = arrayOf("Breakfast", "Lunch", "Dinner")
        val timeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, timeOptions)
        timeSpinner.adapter = timeAdapter

        // Set up Meal Spinner based on Time selection
        timeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedTime = timeOptions[position]
                updateMealSpinner(selectedTime)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case where nothing is selected (optional)
            }
        }

        // Add to Cart Button click listener
        addToCartButton.setOnClickListener {
            val selectedMeal = mealSpinner.selectedItem?.toString() ?: ""
            if (selectedMeal.isNotEmpty()) {
                cartItems.add(selectedMeal)
                updateCartTextView()
                suggestionTextView.text = "" // Clear suggestion
            }
        }

        // Submit Order Button click listener
        submitOrderButton.setOnClickListener {
            if (cartItems.isNotEmpty()) {
                val orderMessage = "You have ordered: ${cartItems.joinToString(", ")}"
                suggestionTextView.text = orderMessage
            } else {
                suggestionTextView.text = "Your cart is empty."
            }
        }

        // Reset Button click listener
        resetButton.setOnClickListener {
            cartItems.clear()
            updateCartTextView()
            suggestionTextView.text = ""
        }
    }

    private fun updateMealSpinner(time: String) {
        val mealOptions = when (time) {
            "Breakfast" -> arrayOf("Oatmeal", "Pancakes", "Eggs", "Cereal")
            "Lunch" -> arrayOf("Sandwich", "Salad", "Soup", "Pizza")
            "Dinner" -> arrayOf("Steak", "Pasta", "Chicken", "Tacos")
            else -> arrayOf()
        }

        val mealAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, mealOptions)
        mealSpinner.adapter = mealAdapter
    }

    @SuppressLint("SetTextI18n")
    private fun updateCartTextView() {
        cartTextView.text = getString(R.string.cart_label) + cartItems.joinToString(", ")
    }
}