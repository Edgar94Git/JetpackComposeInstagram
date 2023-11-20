package com.ereyes.jetpackcomposeinstagram.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/****
 * Project: JetpackComposeInstagram
 * From: com.ereyes.jetpackcomposeinstagram.core.network
 * Created by Edgar Reyes Gonzalez on 11/20/2023 at 11:07 AM
 * All rights reserved 2023.
 ****/
object RetrofitHelper {
    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}