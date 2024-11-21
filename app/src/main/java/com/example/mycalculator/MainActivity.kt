package com.example.mycalculator

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{
    var operators: Array<String> = arrayOf("+", "-", "*", "/")

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main))
        { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spinner: Spinner = findViewById(R.id.spinnerOperators)

        ArrayAdapter.createFromResource(
            this,
            R.array.operators,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            spinner.adapter = adapter
        }
    }

    fun calculateResult(view: View)
    {
        val editTextFirstNum: EditText = findViewById(R.id.editTextFirstNum)
        val editTextSecondNum: EditText = findViewById(R.id.editTextSecondNum)
        val editTextResult: EditText = findViewById(R.id.editTextResult)
        val spinnerOperators: Spinner = findViewById(R.id.spinnerOperators)

        editTextResult.text.clear()

        var result: Double = 0.0
        if(spinnerOperators.selectedItem.toString() == "+")
        {
            result = editTextFirstNum.text.toString().toDouble() +
                    editTextSecondNum.text.toString().toDouble()
        }
        else if(spinnerOperators.selectedItem.toString() == "-")
        {
            result = editTextFirstNum.text.toString().toDouble() -
                    editTextSecondNum.text.toString().toDouble()
        }
        else if(spinnerOperators.selectedItem.toString() == "x")
        {
            result = editTextFirstNum.text.toString().toDouble() *
                    editTextSecondNum.text.toString().toDouble()
        }
        else if(spinnerOperators.selectedItem.toString() == "/")
        {
            result = editTextFirstNum.text.toString().toDouble() /
                    editTextSecondNum.text.toString().toDouble()
        }

        editTextResult.text.append(result.toString())
    }


}