package com.example.mypc.pweather

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var getForecastButton = findViewById<Button>(R.id.getForecastButton)
        getForecastButton.setOnClickListener {
            var moveIntent = Intent(this, ForecastActivity::class.java )
            startActivity(moveIntent)
        }
    }
}
