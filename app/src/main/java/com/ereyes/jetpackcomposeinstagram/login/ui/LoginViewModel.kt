package com.ereyes.jetpackcomposeinstagram.login.ui

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ereyes.jetpackcomposeinstagram.login.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/****
 * Project: JetpackComposeInstagram
 * From: com.ereyes.jetpackcomposeinstagram.login
 * Created by Edgar Reyes Gonzalez on 11/20/2023 at 9:16 AM
 * All rights reserved 2023.
 ****/

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel() {

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

    fun onLoginSelected(){
        viewModelScope.launch {
            val result = loginUseCase(email.value!!, password.value!!)
            if(result)
            {
                Log.i("Result", "Success")
            }
        }
    }
}