package com.ereyes.jetpackcomposeinstagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/****
 * Project: JetpackComposeInstagram
 * From: com.ereyes.jetpackcomposeinstagram
 * Created by Edgar Reyes Gonzalez on 10/2/2023 at 7:36 AM
 * All rights reserved 2023.
 ****/

@Composable
fun TuitTwitter(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFF181818))
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                ImageProfile()
                TuitBody()
            }
            Spacer(modifier = Modifier.size(16.dp))
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
            )
        }
    }
}

@Composable
fun TuitBody() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)
    ) {
        TitleTuit()
        Spacer(modifier = Modifier.size(16.dp))
        TextBody()
        Spacer(modifier = Modifier.size(16.dp))
        ImageBody()
        Row(modifier = Modifier.fillMaxWidth()){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_chat),
                    contentDescription = "Icon chat",
                    tint = Color.LightGray
                )
            }
            Text(text = "1", color = Color.LightGray)
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_rt),
                    contentDescription = "Icon rt",
                    tint = Color.LightGray
                )
            }
            Text(text = "1", color = Color.LightGray)
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_like),
                    contentDescription = "Icon Like",
                    tint = Color.LightGray
                )
            }
            Text(text = "1", color = Color.LightGray)
        }
    }
}

@Composable
fun ImageBody() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Image Tuit",
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(50f))
    )
}

@Composable
fun TextBody() {
    Text(
        text = "Mensaje digital que se envía a través de la red social Twitter® y que no puede rebasar un número limitado de caracteres.",
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        fontSize = 16.sp
    )
}

@Composable
fun TitleTuit() {
    Row(modifier = Modifier
        .fillMaxWidth()
    ){
        Text(
            text = "Edgar",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "@Ereyes-94",
            fontSize = 16.sp,
            color = Color.LightGray
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "4h",
            fontSize = 16.sp,
            color = Color.LightGray
        )
        Spacer(modifier = Modifier.width(100.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = "Option",
            tint = Color.White
        )
    }
}

@Composable
fun ImageProfile() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Profile",
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
    )
}
