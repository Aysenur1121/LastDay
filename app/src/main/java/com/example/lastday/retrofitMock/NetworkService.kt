package com.example.lastday.retrofitMock

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// provideRetrofitInstance() creates a Retrofit instance using the base URL of your mockApi.io API and sets up a GsonConverterFactory for JSON parsing.
fun provideRetrofitInstance(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://6599ea6e652b843dea53373b.mockapi.io/retrofitMock/:endpoint") // my mockApi.io base URL
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

//provideApiService uses the retrofit.create() method to generate an implementation of the MockApiService interface.
fun provideApiService(retrofit: Retrofit): MockApiService {
    return retrofit.create(MockApiService::class.java)
}
