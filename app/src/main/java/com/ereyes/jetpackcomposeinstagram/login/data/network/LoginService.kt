package com.ereyes.jetpackcomposeinstagram.login.data.network

import com.ereyes.jetpackcomposeinstagram.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/****
 * Project: JetpackComposeInstagram
 * From: com.ereyes.jetpackcomposeinstagram.login.data.network
 * Created by Edgar Reyes Gonzalez on 11/20/2023 at 11:21 AM
 * All rights reserved 2023.
 ****/
class LoginService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin(user: String, password: String): Boolean{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(LoginClient::class.java).doLogin()
            response.body()?.success ?: false
        }
    }
}