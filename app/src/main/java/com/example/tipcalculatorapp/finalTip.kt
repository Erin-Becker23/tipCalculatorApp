package com.example.tipcalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class finalTip : AppCompatActivity() {

    lateinit var resultTip: TextView
    lateinit var tipJar: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_tip)

        resultTip = findViewById(R.id.final_tip)
        tipJar = findViewById(R.id.tip_jar)

        val tipInput = intent.getDoubleExtra("EXTRA_INPUT", 0.0)
        val tipChoice = intent.getStringExtra("EXTRA_CHOICE")
        val tipCharges = intent.getStringExtra("EXTRA_CHARGES")

        var finalString =   "The $tipInput tip of $tipChoice is $tipCharges"
        resultTip.text = finalString

    }
}