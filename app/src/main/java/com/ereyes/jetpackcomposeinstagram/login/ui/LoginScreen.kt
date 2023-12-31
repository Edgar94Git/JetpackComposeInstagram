package com.ereyes.jetpackcomposeinstagram.login.ui

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ereyes.jetpackcomposeinstagram.R

/****
 * Project: JetpackComposeInstagram
 * From: com.ereyes.jetpackcomposeinstagram
 * Created by Edgar Reyes Gonzalez on 9/24/2023 at 7:49 AM
 * All rights reserved 2023.
 ****/

@Composable
fun LoginScreen(loginViewModel: LoginViewModel){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center), loginViewModel)
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun Body(modifier: Modifier, loginViewModel: LoginViewModel) {
    val email: String by loginViewModel.email.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")
    val isLoginEnable: Boolean by loginViewModel.isLoginEnable.observeAsState(initial = false)
    Column(modifier = modifier) {
        Logo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        EmailTextField(email) {
            loginViewModel.onLoginChanged(email = it, password = password)
        }
        Spacer(modifier = Modifier.size(4.dp))
        PasswordTextField(password) {
            loginViewModel.onLoginChanged(email = email, password = it)
        }
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton(isLoginEnable, loginViewModel)
        Spacer(modifier = Modifier.size(16.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(32.dp))
        SocialLogin()
    }
}

@Composable
fun Footer(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Divider(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color(0xFFF9F9F9))
        )
        Spacer(modifier = Modifier.size(24.dp))
        SingUp()
        Spacer(modifier = Modifier.size(24.dp))
    }
}

@Composable
fun SingUp() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Don't have an account?",
            color = Color(0xFFB5B5B5),
            fontSize = 12.sp
        )
        Text(
            text = "Sing up.",
            color =  Color(0xFF4EABE9),
            fontSize = 12.sp,
            modifier = Modifier
                .padding(horizontal = 8.dp),
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun SocialLogin() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fb),
            contentDescription = "Social login fb",
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = "Continue as Edgar",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp),
            color = Color(0xFF4EABE9)
        )
    }
}

@Composable
fun LoginDivider() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            modifier = Modifier.padding(horizontal = 18.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = Color(0xFFB5B5B5)
        )
        Divider(
            modifier = Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun LoginButton(loginEnable: Boolean, viewModel: LoginViewModel) {
    Button(
        onClick = { viewModel.onLoginSelected() },
        enabled = loginEnable,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4EA8E9),
            disabledContainerColor = Color(0xFF78C8F9),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
        Text(text = "Log In")    
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "Forgot Password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EABE9)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(password:String, onValueChange: (String) -> Unit) {
    var passwordVisibility by remember { mutableStateOf(false) }
    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = password,
        onValueChange = { onValueChange(it) },
        placeholder = {
            Text(
                text = "Password",
                color = Color(0xFFB5B5B5)
            )
        },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if(passwordVisibility){
                Icons.Filled.VisibilityOff
            }else{
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = image, contentDescription = "Show password")
            }
        },
        visualTransformation = if(passwordVisibility){
            VisualTransformation.None
        }else {
            PasswordVisualTransformation()
        },
        colors = TextFieldDefaults.textFieldColors(
            //textColor = Color(0xFFB5B5B5),
            containerColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextField(email:String, onValueChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = email,
        onValueChange = { onValueChange(it) },
        placeholder = {
            Text(
                text = "Phone number, username or email",
                color = Color(0xFFB5B5B5)
            )
        },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            //textColor = Color(0xFFB5B5B5),
            containerColor = Color(0xFFFAFAFA),
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun Logo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.insta),
        contentDescription = "logo",
        modifier = modifier
            .height(100.dp)
            .width(200.dp)
    )
}

@Composable
fun Header(modifier: Modifier){
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "close app",
        modifier = modifier
            .clickable {
                activity.finish()
            }
    )
}