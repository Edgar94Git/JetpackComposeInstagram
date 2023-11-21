package com.ereyes.jetpackcomposeinstagram.login.data

import com.ereyes.jetpackcomposeinstagram.login.data.network.LoginService
import javax.inject.Inject

/****
 * Project: JetpackComposeInstagram
 * From: com.ereyes.jetpackcomposeinstagram.login.data
 * Created by Edgar Reyes Gonzalez on 11/20/2023 at 12:08 PM
 * All rights reserved 2023.
 ****/
class LoginRepository @Inject constructor(private val loginService: LoginService) {

    suspend fun doLogin(user: String, password: String): Boolean{
        return loginService.doLogin(user, password)
    }
}