package com.ereyes.jetpackcomposeinstagram.login.data.network.response

import com.google.gson.annotations.SerializedName

/****
 * Project: JetpackComposeInstagram
 * From: com.ereyes.jetpackcomposeinstagram.login.data.network.response
 * Created by Edgar Reyes Gonzalez on 11/20/2023 at 11:15 AM
 * All rights reserved 2023.
 ****/
data class LoginResponse(
    @SerializedName("success") val success: Boolean
)
