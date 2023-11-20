package com.ereyes.jetpackcomposeinstagram.login.domain

import com.ereyes.jetpackcomposeinstagram.login.data.LoginRepository

/****
 * Project: JetpackComposeInstagram
 * From: com.ereyes.jetpackcomposeinstagram.login.domain
 * Created by Edgar Reyes Gonzalez on 11/20/2023 at 12:12 PM
 * All rights reserved 2023.
 ****/
class LoginUseCase {
    private val repository = LoginRepository()
    suspend operator fun invoke(user: String, password: String): Boolean{
        return repository.doLogin(user, password)
    }
}