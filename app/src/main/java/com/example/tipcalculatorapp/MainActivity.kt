package com.example.tipcalculatorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var percentGroup: Spinner
    lateinit var costInput: EditText
    lateinit var tipButton: Button
    lateinit var resultOutput: TextView
    lateinit var tipImage: ImageView

    var inputCost = 0.0
    var tipCost = 0.0
    var tipPercent = 0.0
    var tipChoice = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        percentGroup = findViewById(R.id.percent_spinner)
        costInput = findViewById(R.id.cost_Input)
        tipButton = findViewById(R.id.tip_button)
        resultOutput = findViewById(R.id.result_output)
        tipImage = findViewById(R.id.tip_image)


        tipButton.setOnClickListener {
            if (checkData(true))
                inputCost = costInput.text.toString().toDouble()
            tipChoice = percentGroup.selectedItem.toString()
            if (tipChoice == "5%") {
                tipPercent = .05
            } else if (tipChoice == "10%") {
                tipPercent = .10
            } else if (tipChoice == "15%") {
                tipPercent = .15
            } else if (tipChoice == "20%") {
                tipPercent = .2
            } else if (tipChoice == "25%") {
                tipPercent = .25
            }
            tipCost = inputCost * tipPercent

            val currency = DecimalFormat("$##,###.##")
            val tipFormatted = currency.format(tipCost)

            val result = "The $tipChoice tip of $$inputCost is $tipFormatted"
            resultOutput.text = result


            Intent(this@MainActivity, finalTip::class.java).also {
                it.putExtra("EXTRA_INPUT", inputCost)
                it.putExtra("EXTRA_CHOICE", tipChoice)
                it.putExtra("EXTRA_CHARGES", tipFormatted)

                startActivity(it)

            }
        }

    }

    private fun checkData(b: Boolean): Boolean {
        if (costInput.text.toString().isEmpty()) {
            costInput.error = "Invalid hour input"
            costInput.requestFocus()
            return false
        }
        return true
    }
}



