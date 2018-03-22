package com.example.mypc.pweather

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by My PC on 3/22/2018.
 */

interface WeatherAPI {
    @GET("yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D\"kathmandu\")&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
    fun getForecast() : Call<Weather>
}

class Weather()

class WeatherRetriever {
    val service : WeatherAPI

    init {
        val retrofit = Retrofit.Builder().baseUrl("https://query.yahooapis.com/v1/public/").addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(WeatherAPI::class.java)
    }

    fun getForecast(callback: Callback<Weather>) {
        val call = service.getForecast()
        call.enqueue(callback)
    }
}