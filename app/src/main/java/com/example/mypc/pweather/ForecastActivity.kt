package com.example.mypc.pweather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        var listView = findViewById<ListView>(R.id.forecastListView)


        //make a list of your favorite movies and list them in the listview

        var favMovies = listOf<"Friends", "">()

        var retriver = WeatherRetriever()

        val callback = object : Callback<Weather> {
            override fun onFailure(call: Call<Weather>?, t: Throwable?) {
                println("Not working :(")
            }

            override fun onResponse(call: Call<Weather>?, response: Response<Weather>?) {
                println("It's working")
            }
        }

        retriver.getForecast(callback)
    }
}
