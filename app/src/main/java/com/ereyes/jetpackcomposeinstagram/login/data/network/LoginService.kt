package com.ereyes.jetpackcomposeinstagram.login.data.network

import com.ereyes.jetpackcomposeinstagram.login.data.network.response.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

/****
 * Project: JetpackComposeInstagram
 * From: com.ereyes.jetpackcomposeinstagram.login.data.network
 * Created by Edgar Reyes Gonzalez on 11/20/2023 at 11:21 AM
 * All rights reserved 2023.
 ****/
class LoginService @Inject constructor(private val loginClient: LoginClient) {

    suspend fun doLogin(user: String, password: String): Boolean{
        return withContext(Dispatchers.IO){
            val response: Response<LoginResponse> = loginClient.doLogin()
            response.body()?.success ?: false
        }
    }
}