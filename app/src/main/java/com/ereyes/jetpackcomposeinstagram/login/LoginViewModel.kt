package com.ereyes.jetpackcomposeinstagram.login

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/****
 * Project: JetpackComposeInstagram
 * From: com.ereyes.jetpackcomposeinstagram.login
 * Created by Edgar Reyes Gonzalez on 11/20/2023 at 9:16 AM
 * All rights reserved 2023.
 ****/
class LoginViewModel: ViewModel() {

    private val _email: MutableLiveData<String> = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password: MutableLiveData<String> = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnable: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    fun onLoginChanged(email: String, password: String){
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password)
    }

    private fun enableLogin(email: String, password: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 6
    }
}