package com.ereyes.jetpackcomposeinstagram.login.data.network

import com.ereyes.jetpackcomposeinstagram.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

/****
 * Project: JetpackComposeInstagram
 * From: com.ereyes.jetpackcomposeinstagram.login.data.network
 * Created by Edgar Reyes Gonzalez on 11/20/2023 at 11:11 AM
 * All rights reserved 2023.
 ****/
interface LoginClient {

    @GET("/v3/e8cd9ad2-38ff-4da2-a230-fa6eb105c520")
    suspend fun doLogin(): Response<LoginResponse>
}